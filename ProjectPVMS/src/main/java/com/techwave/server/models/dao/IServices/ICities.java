package com.techwave.server.models.dao.IServices;

import java.util.List;

public interface ICities {

	public List<String> getAllCitiesByStateName(String stateName);
}
