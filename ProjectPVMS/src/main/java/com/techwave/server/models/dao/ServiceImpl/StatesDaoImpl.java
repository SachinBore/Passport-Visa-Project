package com.techwave.server.models.dao.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.IStates;
import com.techwave.server.models.pojo.States;
import com.techwave.server.models.repositories.StateRepo.StateRepository;

@Service
public class StatesDaoImpl implements IStates {

	@Autowired
	StateRepository stateRepository;
	
	public List<States> getAllStates() {
		List<States> allStates = (List<States>) stateRepository.findAll();
		return allStates;
	}
}
