package com.techwave.server.controllers.LoginController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.server.models.bao.AuthenticationBao.AuthenticationBao;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	AuthenticationBao authenticationBao;

	@PostMapping("/login/{userId}/{password}")
	public ResponseEntity<String> login(@PathVariable("userId") String encodedUsername,
			@PathVariable("password") String encodedPassword) throws UnsupportedEncodingException {

		String username = URLDecoder.decode(encodedUsername, "UTF-8");
		String password = URLDecoder.decode(encodedPassword, "UTF-8");
		
		String message = authenticationBao.login(username, password);
		return ResponseEntity.of(Optional.of(message));
	}
	
	
	@PostMapping("/adminLogin/{adminId}/{password}")
	public ResponseEntity<String> adminLogin(@PathVariable("adminId") String adminId,
			@PathVariable("password") String password) {

		String message = authenticationBao.adminLogin(adminId, password);
		return ResponseEntity.of(Optional.of(message));
	}
	
	

	@GetMapping("/logout/{username}")
	public ResponseEntity<String> logout(@PathVariable("username") String username) {
		String message = authenticationBao.logout(username);
		return ResponseEntity.of(Optional.of(message));
	}

}
