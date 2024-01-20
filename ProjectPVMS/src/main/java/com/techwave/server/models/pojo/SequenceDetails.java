package com.techwave.server.models.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sequence_details")
public class SequenceDetails {

	@Id
	private String sequenceType;
	private int currentSequence;

	public SequenceDetails() {
		super();
	}

	public SequenceDetails(String sequenceType, int currentSequence) {
		super();
		this.sequenceType = sequenceType;
		this.currentSequence = currentSequence;
	}

	public String getSequenceType() {
		return sequenceType;
	}

	public void setSequenceType(String sequenceType) {
		this.sequenceType = sequenceType;
	}

	public int getCurrentSequence() {
		return currentSequence;
	}

	public void setCurrentSequence(int currentSequence) {
		this.currentSequence = currentSequence;
	}
}
