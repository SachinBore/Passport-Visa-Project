package com.techwave.client.controllers.VisaApplyController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.models.pojo.PassportDetails;
import com.techwave.client.models.pojo.UserDetails;
import com.techwave.client.models.pojo.VisaDetails;
import com.techwave.client.models.restconnect.passport_urls;
import com.techwave.client.models.restconnect.visa_urls;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class VisaApplyController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/applyVisa")
	public String applyVisa(Model M,HttpServletRequest request) {
		// session atrribute
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		VisaDetails v = new VisaDetails();

		v.setUserId(userDetails);
		v.setVisaId(null);

		v.setExpiryDate(null);
		v.setDateOfIssue(null);
		v.setRegistrationCost(null);
		v.setStatus(null);
		v.setDateOfApplication(LocalDate.now());
		// when we get session attribute
		// m.addAttribute("userId",userid);
		M.addAttribute("visaDetails", v);

		try {
			ResponseEntity<PassportDetails[]> response2 = restTemplate.getForEntity(
					passport_urls.GET_USER_PASSPORT_BY_ID_AND_STATUS, PassportDetails[].class,
					v.getUserId().getUserId(), "Active");

			PassportDetails[] details = response2.getBody();
			if (details.length == 0) {
				M.addAttribute("message", "You cannot apply for a visa if you do not have a passport.");
			} else {

				String passportId = details[0].getPassportId();

				PassportDetails passportdetail = new PassportDetails();
				passportdetail.setPassportId(passportId);
				v.setPassportId(passportdetail);

			}

		} catch (Exception e) {

			M.addAttribute("message",
					"The server returned an error. Please check back in a little while :)");

		}

		return "VisaApply";
	}

	@RequestMapping("/insertIntoVisa")
	public String insertIntoVisa(@Valid @ModelAttribute("visaDetails") VisaDetails VisaDetails, BindingResult result,
			Model m) {
		if (!result.hasErrors()) {
			try {
				ResponseEntity<String> message = restTemplate.postForEntity(visa_urls.APPLY_VISA, VisaDetails,
						String.class);

				m.addAttribute("message", message.getBody());
				
		
				
				
			} catch (Exception e) {
				// check this 
				m.addAttribute("message", "The server returned an error. Please check back in a little while :)");
			}
		}
		return "VisaApply";
	}
}