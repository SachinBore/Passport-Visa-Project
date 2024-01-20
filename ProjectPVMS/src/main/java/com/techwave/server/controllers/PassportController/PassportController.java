package com.techwave.server.controllers.PassportController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.server.models.bao.PassportBao.PassportBao;
import com.techwave.server.models.pojo.PassportDetails;

@RestController
@CrossOrigin
public class PassportController {
	
	@Autowired
	PassportBao passportBao;

	@PostMapping("/applyPassport")
	public ResponseEntity<String> applyPassport(@RequestBody PassportDetails passportDetails ) {
		return ResponseEntity.of(Optional.of(passportBao.applyPassport(passportDetails)));
	}
	
	@PostMapping("/reissuePassport")
	public ResponseEntity<String> reissuePassport(@RequestBody PassportDetails passportDetails ) {
		return ResponseEntity.of(Optional.of(passportBao.reissuePassport(passportDetails)));
	}
	
	@GetMapping("/getAllPassports")
	public ResponseEntity<List<PassportDetails>> getAllPassportDetailsFromDb() {
		List<PassportDetails> AllPassportDetailsList = passportBao.getAllPassportDetailsFromDb();
		return ResponseEntity.of(Optional.of(AllPassportDetailsList));
	}
	
	@GetMapping("/getByPassportId/{pid}")
	public ResponseEntity<Object> getPassportDetailByPassportId(@PathVariable("pid") String passportId) {
		PassportDetails passportDetail = passportBao.getPassportDetailByPassportId(passportId);
		if(passportDetail == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Passport Found with passportId: "+passportId);
		}
		return ResponseEntity.of(Optional.of(passportDetail));
	}
	
	@GetMapping("/getPassportByUserId/{uid}")
	public ResponseEntity<Object> getAllPassportDetailsOfAUserByUserId(@PathVariable("uid") String userId) {
		List<PassportDetails> userPassportDetails = passportBao.getAllPassportDetailsOfAUserByUserId(userId);
		if(userPassportDetails == null) {
			return ResponseEntity.ok(Collections.emptyList());
		}
		return ResponseEntity.of(Optional.of(userPassportDetails));
	}
	
	@GetMapping("/getAllPassportByStatus/{status}")
	public ResponseEntity<Object> getAllPassportDetailsByStatus(@PathVariable("status") String status) {
		List<PassportDetails> PassportDetails = passportBao.getAllPassportDetailsByStatus(status);
		if(PassportDetails == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Passport Records Found with "+status+" status");
		}
		return ResponseEntity.of(Optional.of(PassportDetails));
	}
	
	@GetMapping("/getUserPassportStatus/{uid}/{status}")
	public ResponseEntity<List<PassportDetails>> getUserPassportDetailsByStatus(@PathVariable("uid") String userId,@PathVariable("status") String status) {
		List<PassportDetails> userPassportDetails = passportBao.getUserPassportDetailsByStatus(userId, status);
		if(userPassportDetails == null) {
			return ResponseEntity.ok(Collections.emptyList());
		}
		return ResponseEntity.of(Optional.of(userPassportDetails));
	}
}
