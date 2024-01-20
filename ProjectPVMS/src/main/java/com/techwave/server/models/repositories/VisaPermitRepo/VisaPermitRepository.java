package com.techwave.server.models.repositories.VisaPermitRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.VisaPermitDetails;

@Repository
public interface VisaPermitRepository extends CrudRepository<VisaPermitDetails, String>{

}
