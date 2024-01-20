package com.techwave.server.models.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class States {

	@Id
	@Column(length = 10)
	private String stateId;
	@Column(length = 25)
	private String stateName;

	public States() {
		super();
	}

	public States(String stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
