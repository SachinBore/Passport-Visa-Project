package com.techwave.server.models.dao.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.ISequences;
import com.techwave.server.models.pojo.SequenceDetails;
import com.techwave.server.models.repositories.SequenceRepo.SequenceRepository;

@Service
public class SequencesDaoImpl implements ISequences {

	@Autowired
	SequenceRepository sequenceRepository;
	
	@Override
	public String getNextUserIdPassportSequence() {
		
		SequenceDetails sd = sequenceRepository.findById("Passport").orElse(null);
		int currentSequence = sd.getCurrentSequence();

		int updatedSequence = currentSequence + 1;
		sequenceRepository.updateCurrentSequenceBySequenceType("Passport", updatedSequence);
		
		return String.format("%04d", updatedSequence);
	}

	@Override
	public String getNextUserIdVisaSequence() {
		SequenceDetails sd = sequenceRepository.findById("Visa").orElse(null);
		int currentSequence = sd.getCurrentSequence();

		int updatedSequence = currentSequence + 1;
		sequenceRepository.updateCurrentSequenceBySequenceType("Visa", updatedSequence);
		
		return String.format("%04d", updatedSequence);
	}
	
	@Override
	public int getNextPasswordSequence() {
		SequenceDetails sd = sequenceRepository.findById("Password").orElse(null);
		sequenceRepository.updateCurrentSequenceBySequenceType("Password", sd.getCurrentSequence()+1);
		return sd.getCurrentSequence()+1;
	}

	@Override
	public String getNext30PagesPassportSequence() {
		SequenceDetails sd = sequenceRepository.findById("30Pages").orElse(null);
		int currentSequence = sd.getCurrentSequence();

		int updatedSequence = currentSequence + 1;
		sequenceRepository.updateCurrentSequenceBySequenceType("30Pages", updatedSequence);
		return String.format("%04d", updatedSequence);
	}

	@Override
	public String getNext60PagesPassportSequence() {
		SequenceDetails sd = sequenceRepository.findById("60Pages").orElse(null);
		int currentSequence = sd.getCurrentSequence();

		int updatedSequence = currentSequence + 1;
		sequenceRepository.updateCurrentSequenceBySequenceType("60Pages", updatedSequence);
		return String.format("%04d", updatedSequence);
	}

	@Override
	public String getNextVisaIdSequence() {
		SequenceDetails sd = sequenceRepository.findById("VisaId").orElse(null);
		int currentSequence = sd.getCurrentSequence();

		int updatedSequence = currentSequence + 1;
		sequenceRepository.updateCurrentSequenceBySequenceType("VisaId", updatedSequence);
		return String.format("%04d", updatedSequence);
	}
}
