package com.techwave.server.models.dao.IServices;



import com.techwave.server.models.pojo.AuthenticationService;

public interface IAuthentication {
	public AuthenticationService findByUsername(String username);
	public String login(String username, String password);
	public String logout(String username);
	
	public String adminLogin(String adminId, String password);
}
