package com.techwave.server.controllers.StatesCitiesController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.server.models.bao.StatesCitiesBao.StatesCitiesBao;
import com.techwave.server.models.pojo.States;

@RestController
@CrossOrigin
public class StatesCitiesController {

	@Autowired
	StatesCitiesBao statesCitiesBao;
	
	@GetMapping("/getAllStates")
	public ResponseEntity<List<States>> getAllStates() {
		List<States> allStates = statesCitiesBao.getAllStates();
		return ResponseEntity.of(Optional.of(allStates));
	}
	
	@GetMapping("/getAllCitiesByState/{state}")
	public ResponseEntity<List<String>> getAllCitiesByStateName(@PathVariable("state") String stateName) {
		List<String> allCities = statesCitiesBao.getAllCitiesByStateName(stateName);
		return ResponseEntity.of(Optional.of(allCities));
	}
}
