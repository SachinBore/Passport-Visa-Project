package com.techwave.server.controllers.VisaController;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.server.models.bao.VisaBao.VisaBao;
import com.techwave.server.models.pojo.VisaDetails;

@RestController
@CrossOrigin
public class VisaApplyController {
	
	@Autowired
	VisaBao visaBao;
	
	@PostMapping("/applyVisa")
	public ResponseEntity<String> applyVisa(@RequestBody VisaDetails visaDetails) {
		return ResponseEntity.of(Optional.of(visaBao.applyVisa(visaDetails)));
	}
	
	@PutMapping("/cancelVisa/{vid}")
	public ResponseEntity<String> cancelVisa(@PathVariable("vid") String visaId) {
		return ResponseEntity.of(Optional.of(visaBao.cancelVisa(visaId)));
	}
	
	@GetMapping("/getVisaById/{vid}")
	public ResponseEntity<Object> getVisaDetailByVisaId(@PathVariable("vid") String visaId) {
		VisaDetails visaDetail = visaBao.getVisaDetailByVisaId(visaId);
		if(visaDetail == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Visa Found with visaId: "+visaId);
		}
		return ResponseEntity.of(Optional.of(visaDetail));
	}
	
	@GetMapping("/getAllVisas")
	public ResponseEntity<List<VisaDetails>> getAllVisaDetailsFromDb() {
		List<VisaDetails> AllVisaDetailsList = visaBao.getAllVisaDetailsFromDb();
		return ResponseEntity.of(Optional.of(AllVisaDetailsList));	
	}
	
	@GetMapping("/getVisaByUserId/{uid}")
	public ResponseEntity<Object> getAllVisaDetailsOfAUserByUserId(@PathVariable("uid") String userId) {
		List<VisaDetails> userVisaDetails = visaBao.getAllVisaDetailsOfAUserByUserId(userId);
		if(userVisaDetails == null) {
			return ResponseEntity.ok(Collections.emptyList());
		}
		return ResponseEntity.of(Optional.of(userVisaDetails));
	}
	
	@GetMapping("/getAllVisasByStatus/{status}")
	public ResponseEntity<Object> getAllVisaDetailsByStatus(@PathVariable("status") String status) {
		List<VisaDetails> visaDetails = visaBao.getAllVisaDetailsByStatus(status);
		if(visaDetails == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Visa Records Found with "+status+" status");
		}
		return ResponseEntity.of(Optional.of(visaDetails));
	}
	
	@GetMapping("/getUserVisaByIdAndStatus/{uid}/{status}")
	public ResponseEntity<List<VisaDetails>> getUserVisaDetailsByStatus(@PathVariable("uid") String userId,@PathVariable("status") String status) {
	
		
		List<VisaDetails> userVisaDetails = visaBao.getUserVisaDetailsByStatus(userId, status);
		if(userVisaDetails == null) {
			return ResponseEntity.ok(Collections.emptyList());
		}
		return ResponseEntity.ok(userVisaDetails);
	}
	
	@GetMapping("/getUserVisaByIdAndStatus2/{uid}/{status}")
    public ResponseEntity<Object> getUserVisaDetailsByStatus2(@PathVariable("uid") String userId,@PathVariable("status") String status) {

        List<VisaDetails> userVisaDetails = visaBao.getUserVisaDetailsByStatus(userId, status);
        if (userVisaDetails != null) {
            return ResponseEntity.ok(userVisaDetails);
        } else {
            // If userVisaDetails is null, return an empty list
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}
