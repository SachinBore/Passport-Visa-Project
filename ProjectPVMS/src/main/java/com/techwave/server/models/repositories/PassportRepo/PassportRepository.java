package com.techwave.server.models.repositories.PassportRepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.PassportDetails;
import com.techwave.server.models.pojo.UserDetails;

@Repository
public interface PassportRepository extends CrudRepository<PassportDetails, String>{

	List<PassportDetails> findByUserId(UserDetails userDetails);
	List<PassportDetails> findByStatus(String status);
	List<PassportDetails> findByUserIdAndStatus(UserDetails userDetails, String status);
}
