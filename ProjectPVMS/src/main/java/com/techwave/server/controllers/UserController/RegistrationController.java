package com.techwave.server.controllers.UserController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.server.models.bao.RegistrationBao.RegistrationUserBao;
import com.techwave.server.models.pojo.UserDetails;

@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	RegistrationUserBao registrationUserBao;

	@PostMapping("/insertUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails) {

		return ResponseEntity.of(Optional.of(registrationUserBao.saveUserDetailsToDB(userDetails)));
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		List<UserDetails> usersDetailsList = registrationUserBao.getAllUserDetailsFromDB();
		return ResponseEntity.of(Optional.of(usersDetailsList));
	}
	
	@GetMapping("/getUserById/{uid}")
	public ResponseEntity<Object> getUserById(@PathVariable("uid") String userId) {
		UserDetails user = registrationUserBao.getUserDetailFromDbById(userId);
		return ResponseEntity.of(Optional.of(user));
	}
	
	@PutMapping("/updateUser/{uid}")
	public ResponseEntity<String> updateUser(@PathVariable("uid") String userId,@RequestBody UserDetails userDetails) {
		String message = registrationUserBao.updateUser(userId, userDetails);
		return ResponseEntity.of(Optional.of(message));
	}
	
	@GetMapping("/checkEmail/{email}")
	public ResponseEntity<String> checkEmail(@PathVariable("email") String email) {
		String message = registrationUserBao.checkEmail(email);
		return ResponseEntity.of(Optional.of(message));
	}
	
	@GetMapping("/checkContactNo/{contact}")
	public ResponseEntity<String> checkContactNo(@PathVariable("contact") String contact) {
		String message = registrationUserBao.checkContact(contact);
		return ResponseEntity.of(Optional.of(message));
	}
}
