package com.techwave.client.controllers.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.models.pojo.UserDetails;
import com.techwave.client.models.restconnect.loginURLS;
import com.techwave.client.models.restconnect.user_urls;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/getAllUsers")
	public String getAllUsers(Model M) {

		ResponseEntity<UserDetails[]> response = null;

		try {
			response = restTemplate.getForEntity(user_urls.GET_ALL_USERS, UserDetails[].class);

			UserDetails[] allUserDetails = response.getBody();

			if (allUserDetails.length != 0) {
				M.addAttribute("ulist", allUserDetails);
			} else {
				M.addAttribute("message", "No users Found");
			}
		} catch (Exception e) {

			M.addAttribute("message",
					"The server returned an error. Please contact the administrator for more information.");

		}

		return "admin";
	}

	@RequestMapping("/validateAdmin")
	public String validateAdmin(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("un");
		String password = (String) session.getAttribute("psd");

		session.setAttribute("un", null);
		session.setAttribute("psd", null);

		try {
			String url = loginURLS.ADMIN_LOGIN + "/" + username + "/" + password;

			ResponseEntity<String> message = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

			String responseBody = message.getBody();

			if ("Login successful.".equals(responseBody)) {
				session.setAttribute("adminId", username);

				session.setAttribute("loginSuccess", "true");
				return "redirect:/AdminHome";
			} else if ("Invalid credentials.".equals(responseBody)) {
				// have to make it as alert
				m.addAttribute("FailMessage", "Invalid credentials.");
				return "Login";
			} else {
				m.addAttribute("FailMessage", "An error occurred. Please try again.");
				return "Login";
			}
		} catch (Exception e) {
			System.out.println("in the catch block ============" + e.getMessage());
			m.addAttribute("FailMessage",
					"Oops! Our services are currently undergoing maintenance.<br>Please check back in a little while.");
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/AdminHome")
	public String AdminHome(HttpServletRequest request, Model M) {
		HttpSession session = request.getSession();
		String loginSuccess = (String) session.getAttribute("loginSuccess");
		M.addAttribute("loginSuccess", loginSuccess);
		session.setAttribute("loginSuccess", null);

		return "AdminHome";
	}

}
