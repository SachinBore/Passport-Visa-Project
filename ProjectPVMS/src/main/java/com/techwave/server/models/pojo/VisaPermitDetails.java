package com.techwave.server.models.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visa_permit_details")
public class VisaPermitDetails {

	@Id
	private String applicantOccupation;
	private double visaPermit;

	public VisaPermitDetails() {
		super();
	}

	public VisaPermitDetails(String applicantOccupation, double visaPermit) {
		super();
		this.applicantOccupation = applicantOccupation;
		this.visaPermit = visaPermit;
	}

	public String getApplicantOccupation() {
		return applicantOccupation;
	}

	public void setApplicantOccupation(String applicantOccupation) {
		this.applicantOccupation = applicantOccupation;
	}

	public double getVisaPermit() {
		return visaPermit;
	}

	public void setVisaPermit(double visaPermit) {
		this.visaPermit = visaPermit;
	}
}
