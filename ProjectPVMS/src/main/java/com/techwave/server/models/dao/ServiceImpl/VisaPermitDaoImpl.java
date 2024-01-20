package com.techwave.server.models.dao.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IVisaPermit;
import com.techwave.server.models.pojo.VisaPermitDetails;
import com.techwave.server.models.repositories.VisaPermitRepo.VisaPermitRepository;

@Service
public class VisaPermitDaoImpl implements IVisaPermit {
	
	@Autowired
	VisaPermitRepository visaPermitRepository ;

	@Override
	public double getVisaPermit(String applicantOccupation) {
		VisaPermitDetails visaPermitDetail =  visaPermitRepository.findById(applicantOccupation).orElse(null);
		return visaPermitDetail.getVisaPermit();
	}

}
