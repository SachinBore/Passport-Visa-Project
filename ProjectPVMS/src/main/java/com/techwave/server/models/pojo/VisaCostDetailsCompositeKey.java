package com.techwave.server.models.pojo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class VisaCostDetailsCompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String applicantOccupation;
	private String place;

	public VisaCostDetailsCompositeKey() {
		super();
	}

	public VisaCostDetailsCompositeKey(String applicantOccupation, String place) {
		super();
		this.applicantOccupation = applicantOccupation;
		this.place = place;
	}

	public String getApplicantOccupation() {
		return applicantOccupation;
	}

	public void setApplicantOccupation(String applicantOccupation) {
		this.applicantOccupation = applicantOccupation;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
