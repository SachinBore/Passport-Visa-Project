package com.techwave.server.models.pojo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PassportCostDetailsCompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String typeOfService;
	private String passportType;

	public PassportCostDetailsCompositeKey() {
		super();
	}

	public PassportCostDetailsCompositeKey(String typeOfService, String passportType) {
		super();
		this.typeOfService = typeOfService;
		this.passportType = passportType;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public String getPassportType() {
		return passportType;
	}

	public void setPassportType(String passportType) {
		this.passportType = passportType;
	}
}
