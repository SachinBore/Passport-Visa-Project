package com.techwave.server.models.dao.IServices;

import java.util.List;

import com.techwave.server.models.pojo.UserDetails;

public interface IRegistration {
	
	public String saveUserDetailsToDB(UserDetails userDetails);
	public UserDetails getUserDetailFromDbById(String userId);
	
	public List<UserDetails> getAllUserDetailsFromDB();
	public String updateUser(String userId, UserDetails userDetails);
	
	public String checkEmail(String email);
	public String checkContactNo(String contact);
	
}
