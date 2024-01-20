package com.techwave.server.models.bao.VisaBao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.server.models.dao.IServices.IVisa;
import com.techwave.server.models.pojo.VisaDetails;

public class VisaBao {
	
	@Autowired
	IVisa visaDaoImpl;

	public String applyVisa(VisaDetails visaDetails) {
		return visaDaoImpl.applyVisa(visaDetails);
	}

	public VisaDetails getVisaDetailByVisaId(String visaId) {
		return visaDaoImpl.getVisaDetailByVisaId(visaId);
	}

	public List<VisaDetails> getAllVisaDetailsFromDb() {
		return visaDaoImpl.getAllVisaDetailsFromDb();
	}

	public List<VisaDetails> getAllVisaDetailsOfAUserByUserId(String userId) {
		return visaDaoImpl.getAllVisaDetailsOfAUserByUserId(userId);
	}

	public List<VisaDetails> getAllVisaDetailsByStatus(String status) {
		return visaDaoImpl.getAllVisaDetailsByStatus(status);
	}

	public List<VisaDetails> getUserVisaDetailsByStatus(String userId, String status) {
		return visaDaoImpl.getUserVisaDetailsByStatus(userId, status);
	}

	public String cancelVisa(String visaId) {
		return visaDaoImpl.cancelVisa(visaId);
	}
}
