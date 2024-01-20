package com.techwave.server.models.repositories.StateRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.States;

@Repository
public interface StateRepository extends CrudRepository<States, String>{

}
