package com.techwave.client.controllers.PassportApplyController;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.models.pojo.PassportDetails;
import com.techwave.client.models.pojo.PassportDetails2;
import com.techwave.client.models.pojo.UserDetails;
import com.techwave.client.models.restconnect.passport_urls;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PassportApplyController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/applyPassport")
	public String passportApply(Model M,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		
		PassportDetails p = new PassportDetails();
		p.setIssueDate(LocalDate.now());
		p.setPassportId(null);
		p.setCost(null);
		p.setExpiryDate(null);
		p.setPassportId(null);
		p.setCountry("India");

		UserDetails user = new UserDetails();
		user.setUserId(userId);
		System.out.println("userid from sa:"+userId);
		p.setUserId(user);
		M.addAttribute("passport", p);

		try {
			ResponseEntity<PassportDetails[]> response = restTemplate.getForEntity(
					passport_urls.GET_USER_PASSPORT_BY_ID_AND_STATUS, PassportDetails[].class,
					p.getUserId().getUserId(), "Active");

			PassportDetails[] details = response.getBody();

			if (details.length == 1) {

				M.addAttribute("message", "You already applied for passport");
			}

		} catch (Exception e) {
			M.addAttribute("message", null);
		}

		return "applyPassport";
	}

	@RequestMapping("/PassportCheck")
	public String afterPassportApply(@Valid @ModelAttribute("passport") PassportDetails passport, BindingResult result,
			Model m) {

		if (!result.hasErrors()) {
			try {
				ResponseEntity<String> message = restTemplate.postForEntity(passport_urls.APPLY_PASSPORT, passport,
						String.class);
				m.addAttribute("message", message.getBody());

			} catch (Exception e) {
				m.addAttribute("message",
						"The server returned an error. Please contact the administrator for more information");

			}
			return "applyPassport";

		} else {
			return "applyPassport";
		}

	}

	@RequestMapping("/passportReissue")
	public String passportReissue(Model M,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");

		PassportDetails2 passportDetail = new PassportDetails2();
		// by sessionattributte must be done
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		passportDetail.setUserId(userDetails);
		passportDetail.setPin(null);
		passportDetail.setIssueDate(LocalDate.now());
		passportDetail.setExpiryDate(null);
		passportDetail.setCost(null);
		passportDetail.setStatus(null);
		passportDetail.setCountry("India");
		M.addAttribute("passportDetail", passportDetail);

		try {
			ResponseEntity<PassportDetails[]> response = restTemplate.getForEntity(
					passport_urls.GET_USER_PASSPORT_BY_ID_AND_STATUS, PassportDetails[].class,
					passportDetail.getUserId().getUserId(), "Active");

			PassportDetails[] details = response.getBody();

			if (details.length == 0) {
				M.addAttribute("message", "You cannot reapply for a passport if you don't currently possess one.");
			} else {
				
				M.addAttribute("message", null);
			}

		} catch (Exception e) {

			M.addAttribute("message","The server returned an error. Please contact the administrator for more information");

		}

		return "passportReissue";
	}

	@RequestMapping("/reissuingPassport")
	public String ReissuingPassport(@Valid @ModelAttribute("passportDetail") PassportDetails2 passportDetail,
			BindingResult result, Model m) {

		System.out.println("issue date:" + passportDetail.getIssueDate());

		if (!result.hasErrors()) {
			try {
				ResponseEntity<String> message = restTemplate.postForEntity(passport_urls.REISSUE_PASSPORT,
						passportDetail, String.class);
				m.addAttribute("message", message.getBody());

				return "passportReissue";
			} catch (Exception e) {
				m.addAttribute("message",
						"The server returned an error. Please contact the administrator for more information");

				return "passportReissue";
			}

		} else {
			return "passportReissue";
		}

	}
}
