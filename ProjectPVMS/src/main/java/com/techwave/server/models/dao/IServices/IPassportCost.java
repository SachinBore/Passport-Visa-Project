package com.techwave.server.models.dao.IServices;

public interface IPassportCost {
	
	public Double getAmountForPassportTypeAndTypeOfService(String typeOfService, String passportType);
	
}
