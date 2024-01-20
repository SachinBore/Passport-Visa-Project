package com.techwave.server.models.repositories.SequenceRepo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.server.models.pojo.SequenceDetails;

import jakarta.transaction.Transactional;

@Repository
public interface SequenceRepository extends CrudRepository<SequenceDetails,String> {

	@Modifying
    @Transactional
    @Query("UPDATE SequenceDetails s SET s.currentSequence = :updatedSequence WHERE s.sequenceType = :sequenceType")
    void updateCurrentSequenceBySequenceType(String sequenceType, int updatedSequence);

}
