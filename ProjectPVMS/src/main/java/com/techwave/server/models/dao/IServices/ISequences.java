package com.techwave.server.models.dao.IServices;

public interface ISequences {
	
	// userIdPassportSequence 
	public String getNextUserIdPassportSequence();
	
	// userIdVisaSequence
	public String getNextUserIdVisaSequence();

	// passwordSequence
	public int getNextPasswordSequence();
	
	// passportIdSequence
	public String getNext30PagesPassportSequence();
	public String getNext60PagesPassportSequence();
	
	// visaIdSequence
	public String getNextVisaIdSequence();
}
