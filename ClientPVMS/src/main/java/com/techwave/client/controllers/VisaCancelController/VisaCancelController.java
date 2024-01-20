package com.techwave.client.controllers.VisaCancelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.models.pojo.VisaDetails;
import com.techwave.client.models.restconnect.visa_urls;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VisaCancelController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/cancelVisa")
	public String cancelVisa(Model M,HttpServletRequest request) {
		// we actually fetch userId from the session attribute, but as we didn't
		// implemented it yet
		// so we are statically giving the userId here
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");

		// need to send the active visas id based on userId

		 try { 
			ResponseEntity<VisaDetails[]> response = restTemplate.getForEntity(visa_urls.GET_USER_VISA_BY_ID_AND_STATUS, VisaDetails[].class, userId,
					"Active");


			VisaDetails[] userVisaDetails = response.getBody();
			
			  if (userVisaDetails.length == 0) { 
				  M.addAttribute("message","You cannot cancel a visa if you do not possess a visa."); 
				  } else {
			  M.addAttribute("vdlist", userVisaDetails); 
			  }
			
		} catch (Exception e) {
			M.addAttribute("message","The server returned an error. Please contact the administrator for more information.");
		}

		return "cancelVisa";
	}

}
