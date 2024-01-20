package com.techwave.server.models.repositories.AuthenticationRepo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.AuthenticationService;
@Repository
public interface AuthenticationRepositoty extends CrudRepository<AuthenticationService, String> {
	 List<AuthenticationService> findAllByTimestampBefore(LocalDateTime timestamp);
}
