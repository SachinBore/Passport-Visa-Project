package com.techwave.server.models.dao.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IPassport;
import com.techwave.server.models.dao.IServices.IPassportCost;
import com.techwave.server.models.dao.IServices.ISequences;
import com.techwave.server.models.pojo.PassportDetails;
import com.techwave.server.models.pojo.UserDetails;
import com.techwave.server.models.repositories.PassportRepo.PassportRepository;

@Service
public class PassportDaoImpl implements IPassport {

	@Autowired
	PassportRepository passportRepository;

	@Autowired
	ISequences sequencesDaoImpl;

	@Autowired
	IPassportCost passportCostDaoImpl;

	final String BOOKLET_TYPE_30PAGES = "30Pages";
	final String BOOKLET_TYPE_60PAGES = "60Pages";
	final String PASSPORT_PREFIX_30PAGES = "FPS-30";
	final String PASSPORT_PREFIX_60PAGES = "FPS-60";

	@Override
	public String applyPassport(PassportDetails passportDetails) {

		LocalDate expiryDate = passportDetails.getIssueDate().plusYears(10);

		Double cost = generateCost(passportDetails.getTypeOfService(), "NEW");
		
		String passportId = generatePassportId(passportDetails.getBookletType());

		passportDetails.setPassportId(passportId);
		passportDetails.setExpiryDate(expiryDate);
		passportDetails.setCost(cost);
		passportDetails.setStatus("Active");
		passportDetails.setReasonForReissue(null);

		passportRepository.save(passportDetails);
		
		String message = passportId+","+cost+","+expiryDate;

		return message;
	}

	@Override
	public String reissuePassport(PassportDetails passportDetails) {
		
		LocalDate expiryDate = passportDetails.getIssueDate().plusYears(10);

		Double cost = generateCost(passportDetails.getTypeOfService(), "RENEWAL");

		String passportId = generatePassportId(passportDetails.getBookletType());

		List<PassportDetails> userPassportList = getUserPassportDetailsByStatus(passportDetails.getUserId().getUserId(),"Active");
		if (userPassportList.size() != 0) {
			userPassportList.forEach(list -> {
				list.setStatus("Inactive");
				passportRepository.save(list);
			});
		}

		passportDetails.setPassportId(passportId);
		passportDetails.setExpiryDate(expiryDate);
		passportDetails.setCost(cost);
		passportDetails.setStatus("Active");

		passportRepository.save(passportDetails);
		
		DateTimeFormatter D = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		/*
		 * String message = "Passport reissue is successfully done.\n"; message +=
		 * "Passport Id is " + passportId + "\n"; message += "Amount to be paid is Rs."
		 * + cost + "\n"; DateTimeFormatter D =
		 * DateTimeFormatter.ofPattern("dd/MMM/yyyy"); message +=
		 * "Passport issue date is " + D.format(passportDetails.getIssueDate()) +
		 * " and expiry date is " + D.format(expiryDate);
		 */
		
		String message = passportId+","+cost+","+ D.format(passportDetails.getIssueDate())+","+D.format(expiryDate);

		return message;
	}

	@Override
	public PassportDetails getPassportDetailByPassportId(String passportId) {
		return passportRepository.findById(passportId).orElse(null);
	}

	@Override
	public List<PassportDetails> getAllPassportDetailsFromDb() {
		return (List<PassportDetails>) passportRepository.findAll();
	}

	@Override
	public List<PassportDetails> getAllPassportDetailsOfAUserByUserId(String userId) {
		UserDetails userDetail = new UserDetails();
		userDetail.setUserId(userId);
		List<PassportDetails> userPassportDetails = passportRepository.findByUserId(userDetail);

		if (userPassportDetails.isEmpty()) {
			return null;
		}
		return userPassportDetails;

	}
	
	@Override
	public List<PassportDetails> getAllPassportDetailsByStatus(String status) {
		List<PassportDetails> userPassportDetails = passportRepository.findByStatus(status);
		if (userPassportDetails.isEmpty()) {
			return null;
		}
		return userPassportDetails;
	}
	
	@Override
	public List<PassportDetails> getUserPassportDetailsByStatus(String userId, String status) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		List<PassportDetails> userPassportDetails = passportRepository.findByUserIdAndStatus(userDetails,status);
		if (userPassportDetails.isEmpty()) {
			return null;
		}
		return userPassportDetails;
	}
	
	@Override
	public LocalDate getUserPassportExpiryDate(String passportId) {
		PassportDetails passportDetail = passportRepository.findById(passportId).orElse(null);
		return passportDetail.getExpiryDate();
	}

	// Below Methods used for Internal Processing
	private Double generateCost(String typeOfService, String passportType) {
		return passportCostDaoImpl.getAmountForPassportTypeAndTypeOfService(typeOfService, passportType);
	}

	private String generatePassportId(String bookletType) {

		String passportPrefix = "";
		String passportSuffix = "";

		if (BOOKLET_TYPE_30PAGES.equals(bookletType)) {
			passportPrefix = PASSPORT_PREFIX_30PAGES;
			passportSuffix = sequencesDaoImpl.getNext30PagesPassportSequence();
		} else {
			passportPrefix = PASSPORT_PREFIX_60PAGES;
			passportSuffix = sequencesDaoImpl.getNext60PagesPassportSequence();
		}

		return passportPrefix + passportSuffix;
	}
}
