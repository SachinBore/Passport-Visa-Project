package com.techwave.server.models.bao.PassportBao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.server.models.dao.IServices.IPassport;
import com.techwave.server.models.pojo.PassportDetails;

public class PassportBao {

	@Autowired
	IPassport passportDaoImpl;
	
	public String applyPassport(PassportDetails passportDetails) {
		return passportDaoImpl.applyPassport(passportDetails);
	}
	
	public String reissuePassport(PassportDetails passportDetails) {
		return passportDaoImpl.reissuePassport(passportDetails);
	}
	
	public PassportDetails getPassportDetailByPassportId(String passportId) {
		return passportDaoImpl.getPassportDetailByPassportId(passportId);
	}

	public List<PassportDetails> getAllPassportDetailsFromDb() {
		return passportDaoImpl.getAllPassportDetailsFromDb();
	}

	public List<PassportDetails> getAllPassportDetailsOfAUserByUserId(String userId) {
		return passportDaoImpl.getAllPassportDetailsOfAUserByUserId(userId);
	}
	
	public List<PassportDetails> getAllPassportDetailsByStatus(String status) {
		return passportDaoImpl.getAllPassportDetailsByStatus(status);
	}
	
	public List<PassportDetails> getUserPassportDetailsByStatus(String userId, String status) {
		return passportDaoImpl.getUserPassportDetailsByStatus(userId, status);
	}
}
