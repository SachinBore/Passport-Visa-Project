package com.techwave.server.models.repositories.CitiesRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.Cities;

import jakarta.transaction.Transactional;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, String> {

	@Transactional
    @Query("SELECT c.cityName FROM Cities c JOIN c.stateId s WHERE s.stateName = :stateName")
    List<String> findCityNamesByStateName(@Param("stateName") String stateName);
}
