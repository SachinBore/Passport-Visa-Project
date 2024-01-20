package com.techwave.server.models.dao.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IPassportCost;
import com.techwave.server.models.pojo.PassportCostDetails;
import com.techwave.server.models.pojo.PassportCostDetailsCompositeKey;
import com.techwave.server.models.repositories.PassportCostRepo.PassportCostRepository;

@Service
public class PassportCostDaoImpl implements IPassportCost{

	@Autowired
	PassportCostRepository PassportCostRepository;
	
	@Override
	public Double getAmountForPassportTypeAndTypeOfService(String typeOfService, String passportType) {
		
		PassportCostDetailsCompositeKey cKey = new PassportCostDetailsCompositeKey(typeOfService,passportType);
		PassportCostDetails details =  PassportCostRepository.findById(cKey).orElse(null);
		return details.getAmount();
	}

	

}
