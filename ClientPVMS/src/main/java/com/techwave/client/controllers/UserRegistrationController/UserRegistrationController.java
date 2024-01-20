package com.techwave.client.controllers.UserRegistrationController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.models.pojo.PassportDetails;
import com.techwave.client.models.pojo.UserDetails;
import com.techwave.client.models.pojo.VisaDetails;
import com.techwave.client.models.restconnect.passport_urls;
import com.techwave.client.models.restconnect.user_urls;
import com.techwave.client.models.restconnect.visa_urls;

import jakarta.validation.Valid;

@Controller
public class UserRegistrationController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/Registration")
	public String Registration(Model M,HttpServletRequest request) {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setCitizenType(null);
		userDetails.setUserId(null);
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		M.addAttribute("userRegistration", userDetails);
		if(userId != null) {
			M.addAttribute("FailMessage","Please Logout to register");
		} else {
			M.addAttribute("message",null);
		}
		
		
		return "userRegistration";
	}

	@RequestMapping("/RegistrationCheck")
	public String registrationCheck(@Valid @ModelAttribute("userRegistration") UserDetails userDetails,
			BindingResult result, Model M) {

		if (!result.hasErrors()) {

			try {
				  ResponseEntity<String> message =
				  restTemplate.postForEntity(user_urls.SAVE_USER, userDetails, String.class);
	
				  M.addAttribute("message",message.getBody());
				
				return "userRegistration";
				

			} catch (Exception e) {
				M.addAttribute("FailMessage", "Oops! Our services are currently undergoing maintenance.<br>We're working hard to get everything up and running smoothly again.<br>Please check back in a little while.");
				return "userRegistration";
			}

		} else {
			return "userRegistration";
		}

	}
	
	//getbyId and update can be implemented by ajax in Myprofile
	
	@RequestMapping("/myProfile")
	public String myProfile(Model M, HttpServletRequest request) {
		// get userId from session attribute
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		
		try {
			ResponseEntity<UserDetails> userResponse = restTemplate.getForEntity(user_urls.GET_USER_BY_USER_ID,UserDetails.class, userId);
			UserDetails user = userResponse.getBody();
			M.addAttribute("userDetails",user);
			
			ResponseEntity<PassportDetails[]> passportResponse = restTemplate.getForEntity(passport_urls.GET_PASSPORT_BY_USER_ID,PassportDetails[].class,userId);
			PassportDetails[] userPassportDetails = passportResponse.getBody();
			M.addAttribute("passportDetails",userPassportDetails);
			
			ResponseEntity<VisaDetails[]> visaResponse =restTemplate.getForEntity(visa_urls.GET_VISA_BY_USER_ID,VisaDetails[].class, userId);
			VisaDetails[] userVisaDetails = visaResponse.getBody();
			M.addAttribute("visaDetails",userVisaDetails);
			
		} catch(Exception e) {
			M.addAttribute("message","The server returned an error. Please contact the administrator for more information.");
		}
		
		return "myProfile";
	}
	
	

}
