package com.techwave.server.models.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cities {

	@Id
	@Column(length = 10)
	private String cityId;
	
	@ManyToOne
	@JoinColumn(name = "StateId")
	private States stateId;
	@Column(length = 25)
	private String cityName;

	public Cities() {
		super();
	}

	public Cities(String cityId, States stateId, String cityName) {
		super();
		this.cityId = cityId;
		this.stateId = stateId;
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public States getStateId() {
		return stateId;
	}

	public void setStateId(States stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
