package com.techwave.server.models.bao.AuthenticationBao;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.server.models.dao.IServices.IAuthentication;
import com.techwave.server.models.pojo.AuthenticationService;

public class AuthenticationBao {
	@Autowired
	IAuthentication authenticationDao;
	public AuthenticationService findByUsername(String username) {
		return null;
		
	}
	public String login(String username, String password) {
		return authenticationDao.login(username,password);
	}
	public String logout(String username) {
		return authenticationDao.logout(username);
	}
	
	public String adminLogin(String adminId, String password) {
		return authenticationDao.adminLogin(adminId, password);
	}
	
}
