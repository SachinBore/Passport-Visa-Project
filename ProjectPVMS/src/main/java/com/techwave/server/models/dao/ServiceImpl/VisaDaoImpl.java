package com.techwave.server.models.dao.ServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IPassport;
import com.techwave.server.models.dao.IServices.ISequences;
import com.techwave.server.models.dao.IServices.IVisa;
import com.techwave.server.models.dao.IServices.IVisaCost;
import com.techwave.server.models.dao.IServices.IVisaPermit;
import com.techwave.server.models.pojo.UserDetails;
import com.techwave.server.models.pojo.VisaDetails;
import com.techwave.server.models.repositories.VisaRepo.VisaRepository;

@Service
public class VisaDaoImpl implements IVisa {

	@Autowired
	VisaRepository visaRepository;

	@Autowired
	ISequences sequencesDaoImpl;

	@Autowired
	IPassport passportDaoImpl;

	@Autowired
	IVisaPermit visaPermitDaoImpl;

	@Autowired
	IVisaCost visaCostDaoImpl;

	@Override
	public String applyVisa(VisaDetails visaDetails) {

		// check if the visa applied country visa is already applied and it is active
		// visa then display message as
		// You already applied visa for this country, to apply again cancel it and apply
		// again
		if (checkVisaAlreadyExist(visaDetails.getUserId().getUserId(), visaDetails.getCountry(), "Active")) {
			// check if the passport expiryDate is less than visa date of application + 10
			// days
			// if it is less than 10 days then give a message to user mentioning - u can't
			// get visa because your passport is expiring in ?? days
			// if it is not less than 10 days then check for visa expiryDate is greater than
			// passport expiryDate
			// if it is greater then change visa expiryDate to same as passport expiryDate,
			// else visa expiryDate is visa issue date + 10 years
			if (checkIssueDate(visaDetails.getDateOfApplication().plusDays(10),visaDetails.getPassportId().getPassportId())) {

				LocalDate issueDate = visaDetails.getDateOfApplication().plusDays(10);

				LocalDate passportExpiryDate = passportDaoImpl.getUserPassportExpiryDate(visaDetails.getPassportId().getPassportId());

				double visaPermit = visaPermitDaoImpl.getVisaPermit(visaDetails.getOccupation());

				int years = (int) visaPermit;
				int months = (int) ((visaPermit - years) * 10);
				LocalDate expiryDate = issueDate.plusYears(years).plusMonths(months);

				if (expiryDate.compareTo(passportExpiryDate) > 0) {
					expiryDate = passportExpiryDate;
				}

				Double registrationCost = visaCostDaoImpl.getVisaRegistrationCost(visaDetails.getOccupation(),
						visaDetails.getCountry());

				String visaId = generateVisaId();

				visaDetails.setDateOfIssue(issueDate);
				visaDetails.setExpiryDate(expiryDate);
				visaDetails.setVisaId(visaId);
				visaDetails.setRegistrationCost(registrationCost);
				visaDetails.setStatus("Active");

				visaRepository.save(visaDetails);

				DateTimeFormatter D = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

				/*
				 * String message =
				 * "Dear User,\nyour Visa request has been accepted successfully with visaId: "
				 * + visaId + ", userId: " + visaDetails.getUserId().getUserId() + "\n"; message
				 * += "Destination: " + visaDetails.getCountry() + "\n"; message +=
				 * "Employee Occupation: " + visaDetails.getOccupation() + "\n"; message +=
				 * "Date of Application: " + D.format(visaDetails.getDateOfApplication()) +
				 * "\n"; message += "Date of Issue: " + D.format(issueDate) + "\n"; message +=
				 * "Date of Expiry: " + D.format(expiryDate) + "\n"; message +=
				 * "Registration cost: " + registrationCost;
				 */
				
				String message = visaId+","+visaDetails.getOccupation()+","+D.format(issueDate)+","+D.format(visaDetails.getExpiryDate())+","+registrationCost;
				return message;
			}

			return "Your Passport is Expiring in less than 10 days, So apply Passport again to apply for Visa";
		}

		return "You already applied visa for " + visaDetails.getCountry() + ", to apply again. cancel it and apply";
	}

	@Override
	public String cancelVisa(String visaId) {
		VisaDetails visaDetails = visaRepository.findById(visaId).get();
		visaDetails.setStatus("Inactive");

		int cancellationCharge = calculateCancellationCharge(visaDetails.getOccupation(), visaDetails.getExpiryDate());

		visaRepository.save(visaDetails);

		String message = "Your request has been submitted successfully.\n";
		message += "Please pay " + cancellationCharge + " to complete the cancellation process.";
		return message;
	}

	@Override
	public VisaDetails getVisaDetailByVisaId(String visaId) {
		return visaRepository.findById(visaId).orElse(null);
	}

	@Override
	public List<VisaDetails> getAllVisaDetailsFromDb() {
		return (List<VisaDetails>) visaRepository.findAll();
	}

	@Override
	public List<VisaDetails> getAllVisaDetailsOfAUserByUserId(String userId) {
		UserDetails userDetail = new UserDetails();
		userDetail.setUserId(userId);
		List<VisaDetails> userVisaDetails = visaRepository.findByUserId(userDetail);

		if (userVisaDetails.isEmpty()) {
			return null;
		}
		return userVisaDetails;
	}

	@Override
	public List<VisaDetails> getAllVisaDetailsByStatus(String status) {
		List<VisaDetails> allVisaDetails = visaRepository.findByStatus(status);
		if (allVisaDetails.isEmpty()) {
			return null;
		}
		return allVisaDetails;
	}

	@Override
	public List<VisaDetails> getUserVisaDetailsByStatus(String userId, String status) {
		UserDetails userDetail = new UserDetails();
		userDetail.setUserId(userId);

		List<VisaDetails> userVisaDetails = visaRepository.findByUserIdAndStatus(userDetail, status);
		if (userVisaDetails.isEmpty()) {
			return null;
		}
		return userVisaDetails;
	}

	// Below Methods used for Internal Processing
	private boolean checkVisaAlreadyExist(String userId, String country, String status) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		List<VisaDetails> visaDetails = visaRepository.findByUserIdAndCountryAndStatus(userDetails, country, status);
		if (visaDetails.size() == 0) {
			return true;
		}
		return false;
	}

	private String generateVisaId() {

		String visaPrefix = "VISA";
		String visaSuffix = sequencesDaoImpl.getNextVisaIdSequence();

		return visaPrefix + visaSuffix;
	}

	private boolean checkIssueDate(LocalDate issueDate, String passportId) {

		LocalDate passportExpiryDate = passportDaoImpl.getUserPassportExpiryDate(passportId);

		if (issueDate.compareTo(passportExpiryDate) >= 0) {
			return false;
		}
		return true;
	}

	private int calculateCancellationCharge(String occupation, LocalDate expiryDate) {

		LocalDate today = LocalDate.now();
		Period period = Period.between(today, expiryDate);
		int monthsDifference = period.getYears() * 12 + period.getMonths();

		// these are the static data and should use another logic: may be table
		if (occupation.equals("Student")) {
			if (monthsDifference < 6) {
				return 1000;
			} else {
				return 2000;
			}

		} else if (occupation.equals("Private Employee")) {
			if (monthsDifference < 6) {
				return 2500;
			} else if (monthsDifference < 12) {
				return 3500;
			} else {
				return 4500;
			}

		} else if (occupation.equals("Government Employee")) {
			if (monthsDifference < 6) {
				return 2000;
			} else if (monthsDifference < 12) {
				return 3000;
			} else {
				return 4000;
			}

		} else if (occupation.equals("Self Employed")) {
			if (monthsDifference < 6) {
				return 1500;
			} else {
				return 2500;
			}

		} else {
			if (monthsDifference < 6) {
				return 700;
			} else {
				return 1500;
			}
		}
	}
}
