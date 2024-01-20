package com.techwave.server.models.repositories.LoginRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, String>{

}
