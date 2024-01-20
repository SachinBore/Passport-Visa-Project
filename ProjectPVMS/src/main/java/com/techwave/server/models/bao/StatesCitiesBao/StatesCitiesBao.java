package com.techwave.server.models.bao.StatesCitiesBao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.server.models.dao.IServices.ICities;
import com.techwave.server.models.dao.IServices.IStates;
import com.techwave.server.models.pojo.States;

public class StatesCitiesBao {

	@Autowired
	IStates StatesDaoImpl;
	
	@Autowired
	ICities CitiesDaoImpl;
	
	public List<States> getAllStates() {
		return StatesDaoImpl.getAllStates();
	}
	
	public List<String> getAllCitiesByStateName(String stateName) {
		return CitiesDaoImpl.getAllCitiesByStateName(stateName);
	}
}
