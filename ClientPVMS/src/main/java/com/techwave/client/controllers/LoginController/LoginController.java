package com.techwave.client.controllers.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;

import com.techwave.client.models.restconnect.loginURLS;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/Login")
	public String Login(HttpServletRequest request, Model M) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		if (userId != null) {
			M.addAttribute("FailMessage", "Please Logout.");
		}
		return "Login";
	}

	@RequestMapping("/FAQs")
	public String FAQS() {
		return "FAQs";
	}

	@RequestMapping("/Logout")
	public String Logout(HttpServletRequest request, Model M) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("username");
		if (userId != null) {
			session.setAttribute("username", null);
			session.setAttribute("LogoutMessage", "true");
		} else {
			session.setAttribute("LogoutMessage", null);
		}

		return "redirect:/home";
	}

	@RequestMapping("/ServicesInfo")
	public String beforeLoginServices() {
		return "ServicesInfo";
	}

	@RequestMapping("/services")
	public String services(HttpServletRequest request, Model M) {
		HttpSession session = request.getSession();
		String loginSuccess = (String) session.getAttribute("loginSuccess");
		M.addAttribute("loginSuccess", loginSuccess);
		session.setAttribute("loginSuccess", null);

		return "HomeAfterLogin";
	}

	@RequestMapping("/home")
	public String home2() {
		return "HomeBeforeLogin";
	}

	@RequestMapping("/termsandconditions")
	public String terms() {
		return "TermsAndConditions";
	}

	@RequestMapping("/contactus")
	public String contactus(HttpServletRequest request, Model model) {
		String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
		return "contactus";
	}

	@RequestMapping("/notices")
	public String notices(HttpServletRequest request, Model model) {
		String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
		return "notices";
	}

	@RequestMapping("/aboutus")
	public String aboutus(HttpServletRequest request, Model model) {
		String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
		return "aboutus";
	}

	@RequestMapping("/checkUser")
	public String validateLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (!username.startsWith("Admin")) {

			session.setAttribute("un", username);
			session.setAttribute("psd", password);

			return "redirect:/validateLogin";
		}
		return "redirect:/validateAdmin";
	}

	@RequestMapping("/validateLogin")
	public String home(HttpServletRequest request, Model m) {

		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("un");
		String password = (String) session.getAttribute("psd");

		session.setAttribute("un", null);
		session.setAttribute("psd", null);

		try {

			String encodedUsername = URLEncoder.encode(username, "UTF-8");
			String encodedPassword = URLEncoder.encode(password, "UTF-8");

			String url = loginURLS.LOGIN + "/" + encodedUsername + "/" + encodedPassword;

			ResponseEntity<String> message = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

			String responseBody = message.getBody();
			if ("Login successful.".equals(responseBody)) {
				session.setAttribute("username", username);

				session.setAttribute("loginSuccess", "true");
				return "redirect:/services";
			} else if ("Invalid credentials.".equals(responseBody)) {
				// have to make it as alert
				m.addAttribute("FailMessage", "Invalid credentials.");
				return "Login";
			} else if ("Session exists. Please logout from the existing session.".equals(responseBody)) {

				m.addAttribute("FailMessage", "Session exists. Please logout from the existing session.");
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
}
