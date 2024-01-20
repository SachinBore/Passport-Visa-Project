package com.techwave.server.models.bao.RegistrationBao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.server.models.dao.IServices.IRegistration;
import com.techwave.server.models.pojo.UserDetails;

public class RegistrationUserBao {

	@Autowired
	IRegistration registrationDaoImpl;

	public String saveUserDetailsToDB(UserDetails userDetails) {
		return registrationDaoImpl.saveUserDetailsToDB(userDetails);
	}

	public List<UserDetails> getAllUserDetailsFromDB() {
		return registrationDaoImpl.getAllUserDetailsFromDB();
	}

	public UserDetails getUserDetailFromDbById(String userId) {
		return registrationDaoImpl.getUserDetailFromDbById(userId);
	}

	public String updateUser(String userId, UserDetails userDetails) {
		return registrationDaoImpl.updateUser(userId,userDetails);
	}
	
	public String checkEmail(String email) {
		return registrationDaoImpl.checkEmail(email);
	}
	
	public String checkContact(String contact) {
		return registrationDaoImpl.checkContactNo(contact);
	}
}
