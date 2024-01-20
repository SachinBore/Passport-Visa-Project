package com.techwave.server.models.dao.IServices;

import java.util.List;


import com.techwave.server.models.pojo.VisaDetails;

public interface IVisa {
	
	public String applyVisa(VisaDetails visaDetails);

	public VisaDetails getVisaDetailByVisaId(String visaId);

	public List<VisaDetails> getAllVisaDetailsFromDb();

	public List<VisaDetails> getAllVisaDetailsOfAUserByUserId(String userId);
	
	public List<VisaDetails> getAllVisaDetailsByStatus( String status);
	
	public List<VisaDetails> getUserVisaDetailsByStatus(String userId,String status);

	public String cancelVisa(String visaId);

}
