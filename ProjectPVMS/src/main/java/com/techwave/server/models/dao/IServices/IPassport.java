package com.techwave.server.models.dao.IServices;

import java.time.LocalDate;
import java.util.List;

import com.techwave.server.models.pojo.PassportDetails;

public interface IPassport {
	
	public String applyPassport(PassportDetails passportDetails);
	
	public String reissuePassport(PassportDetails passportDetails);
	
	public PassportDetails getPassportDetailByPassportId(String passportId);
	
	public List<PassportDetails> getAllPassportDetailsFromDb();
	
	public List<PassportDetails> getAllPassportDetailsOfAUserByUserId(String userId);
	
	public List<PassportDetails> getAllPassportDetailsByStatus(String status);
	
	public List<PassportDetails> getUserPassportDetailsByStatus(String userId, String status);
	
	public LocalDate getUserPassportExpiryDate(String passportId);
}
