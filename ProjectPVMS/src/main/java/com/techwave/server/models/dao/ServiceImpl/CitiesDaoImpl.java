package com.techwave.server.models.dao.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.server.models.dao.IServices.ICities;
import com.techwave.server.models.repositories.CitiesRepo.CitiesRepository;

@Service
public class CitiesDaoImpl implements ICities {

	@Autowired
	CitiesRepository citiesRepository;
	
	public List<String> getAllCitiesByStateName(String stateName) {
		List<String> cities = citiesRepository.findCityNamesByStateName(stateName);
		return cities;
	}
	
}
