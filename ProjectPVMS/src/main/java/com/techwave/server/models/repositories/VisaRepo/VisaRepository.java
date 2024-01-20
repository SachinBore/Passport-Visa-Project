package com.techwave.server.models.repositories.VisaRepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.UserDetails;
import com.techwave.server.models.pojo.VisaDetails;

@Repository
public interface VisaRepository extends CrudRepository<VisaDetails, String> {

	List<VisaDetails> findByUserId(UserDetails userDetails);
	List<VisaDetails> findByStatus(String status);
	List<VisaDetails> findByUserIdAndStatus(UserDetails userDetails, String status);
	
	List<VisaDetails> findByUserIdAndCountryAndStatus(UserDetails userDetails,String country,String status);
}
