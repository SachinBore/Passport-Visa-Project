package com.techwave.server.models.dao.ServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IRegistration;
import com.techwave.server.models.dao.IServices.ISequences;
import com.techwave.server.models.pojo.Login;
import com.techwave.server.models.pojo.UserDetails;
import com.techwave.server.models.repositories.LoginRepo.LoginRepository;
import com.techwave.server.models.repositories.RegistrationRepo.RegistrationRepository;

@Service
public class RegistrationDaoImpl implements IRegistration {

	@Autowired
	RegistrationRepository registrationRepositary;

	@Autowired
	ISequences sequencesDaoImpl;

	// use Interface name here - after learning spring security and implementing login
	@Autowired
	LoginRepository loginRepository;

	final String APPLY_TYPE_PASSPORT = "Passport";
	final String APPLY_TYPE_VISA = "Visa";
	final String PASSPORT_USER_ID_PREFIX = "PASS";
	final String VISA_USER_ID_PREFIX = "VISA";

	@Override
	public UserDetails getUserDetailFromDbById(String userId) {
		UserDetails userDetails = registrationRepositary.findById(userId).orElse(null);
		return userDetails;
	}

	@Override
	public String saveUserDetailsToDB(UserDetails userDetails) {

		String citizenType = getCitizenType(userDetails.getDateOfBirth());
		String userId = generateUserId(userDetails.getApplyType());
		String password = generatePassword();

		Login login = new Login();
		login.setUserId(userId);
		login.setPassword(password);
		loginRepository.save(login);

		userDetails.setUserId(userId);
		userDetails.setCitizenType(citizenType);
		registrationRepositary.save(userDetails);

		String message = userId + "," + password + ","+userDetails.getApplyType() +","+ citizenType;
		return message;
	}

	@Override
	public List<UserDetails> getAllUserDetailsFromDB() {
		return (List<UserDetails>) registrationRepositary.findAll();
	}

	@Override
	public String updateUser(String userId, UserDetails userDetails) {
		UserDetails old = getUserDetailFromDbById(userId);
		old.setAddress(userDetails.getAddress());
		old.setQualification(userDetails.getQualification());
		old.setHintQuestion(userDetails.getHintQuestion());
		old.setHintAnswer(userDetails.getHintAnswer());

		registrationRepositary.save(old);
		return "Saved";

	}
	
	@Override
	public String checkEmail(String email) {
		UserDetails user =  registrationRepositary.findByEmailAddress(email);
		if(user == null) {
			return "notExist";
		}
		return "Exist";
	}

	@Override
	public String checkContactNo(String contact) {
		UserDetails user = registrationRepositary.findByContactNo(contact);
		if(user == null) {
			return "notExist";
		}
		return "Exist";
	}

	// Below Methods used for Internal Processing
	private String generatePassword() {

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd");
		DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMM");

		String day = dateFormat.format(currentDate);
		String month = monthFormat.format(currentDate).toLowerCase();

		char[] specialCharacters = { '#', '@', '$' };
		Random random = new Random();
		char specialCharacter = specialCharacters[random.nextInt(specialCharacters.length)];

		int uniqueNumber = sequencesDaoImpl.getNextPasswordSequence();
		String password = day + month + specialCharacter + uniqueNumber;
		return password;
	}

	private String getCitizenType(LocalDate dateOfBirth) {

		LocalDate currentDate = LocalDate.now();
		int age = Period.between(dateOfBirth, currentDate).getYears();

		if (age <= 1)
			return "Infant";
		else if (age <= 10)
			return "Children";
		else if (age <= 20)
			return "Teen";
		else if (age <= 50)
			return "Adult";
		else
			return "Senior Citizen";
	}

	private String generateUserId(String applyType) {

		String userPrefix = "";
		String userSuffix = "";

		if (APPLY_TYPE_PASSPORT.equals(applyType)) {
			userPrefix = PASSPORT_USER_ID_PREFIX;
			userSuffix = sequencesDaoImpl.getNextUserIdPassportSequence();

		} else {
			userPrefix = VISA_USER_ID_PREFIX;
			userSuffix = sequencesDaoImpl.getNextUserIdVisaSequence();
		}

		return userPrefix + "-" + userSuffix;
	}
}
