package com.techwave.server.models.repositories.VisaCostRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.VisaCostDetails;
import com.techwave.server.models.pojo.VisaCostDetailsCompositeKey;

@Repository
public interface VisaCostRepository extends CrudRepository<VisaCostDetails, VisaCostDetailsCompositeKey>{

}
