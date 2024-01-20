package com.techwave.server.models.repositories.PassportCostRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.PassportCostDetails;
import com.techwave.server.models.pojo.PassportCostDetailsCompositeKey;

@Repository
public interface PassportCostRepository extends CrudRepository<PassportCostDetails, PassportCostDetailsCompositeKey>{

}
