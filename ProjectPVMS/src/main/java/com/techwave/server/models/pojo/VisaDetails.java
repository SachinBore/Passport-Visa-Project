package com.techwave.server.models.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="visa_details")
public class VisaDetails {

	@Id
	@Column(length = 10)
	private String visaId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userId;
	
	@ManyToOne
	@JoinColumn(name = "passportId")
	private PassportDetails passportId;
	
	private String country;
	@Column(length=25)
	private String occupation;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfApplication;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfIssue;
	
	private Double registrationCost;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@Column(length = 10)
	private String status;
	
	public VisaDetails() {
		super();
	}

	public VisaDetails(String visaId, UserDetails userId, PassportDetails passportId, String country, String occupation,
			LocalDate dateOfApplication, LocalDate dateOfIssue, Double registrationCost, LocalDate expiryDate,
			String status) {
		super();
		this.visaId = visaId;
		this.userId = userId;
		this.passportId = passportId;
		this.country = country;
		this.occupation = occupation;
		this.dateOfApplication = dateOfApplication;
		this.dateOfIssue = dateOfIssue;
		this.registrationCost = registrationCost;
		this.expiryDate = expiryDate;
		this.status = status;
	}

	public String getVisaId() {
		return visaId;
	}

	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public LocalDate getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(LocalDate dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Double getRegistrationCost() {
		return registrationCost;
	}

	public void setRegistrationCost(Double registrationCost) {
		this.registrationCost = registrationCost;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public PassportDetails getPassportId() {
		return passportId;
	}

	public void setPassportId(PassportDetails passportId) {
		this.passportId = passportId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
