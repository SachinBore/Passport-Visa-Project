package com.techwave.server.models.dao.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IVisaCost;
import com.techwave.server.models.pojo.VisaCostDetails;
import com.techwave.server.models.pojo.VisaCostDetailsCompositeKey;
import com.techwave.server.models.repositories.VisaCostRepo.VisaCostRepository;

@Service
public class VisaCostDaoImpl implements IVisaCost {
	
	@Autowired
	VisaCostRepository visaCostRepository;

	@Override
	public double getVisaRegistrationCost(String applicantOccupation, String place) {
		
		VisaCostDetailsCompositeKey cKey = new VisaCostDetailsCompositeKey(applicantOccupation,place);
		VisaCostDetails visaCostDetails = visaCostRepository.findById(cKey).orElse(null);
		return visaCostDetails.getCost();
	}
	
	
}
