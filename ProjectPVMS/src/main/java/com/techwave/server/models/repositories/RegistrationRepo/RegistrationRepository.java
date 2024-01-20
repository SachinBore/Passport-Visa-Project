package com.techwave.server.models.repositories.RegistrationRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.UserDetails;

@Repository
public interface RegistrationRepository extends  CrudRepository<UserDetails, String>{

	UserDetails findByEmailAddress(String emailAddress);
	UserDetails findByContactNo(String contactNo);
}
