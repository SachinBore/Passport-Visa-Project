package com.techwave.client.models.pojo;



import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;



public class VisaDetails {

	
	private String visaId;
	private UserDetails userId;	
	private PassportDetails passportId;
	@NotBlank(message = "required")
	private String country;
	@NotBlank(message = "required")
	private String occupation;

	@DateTimeFormat(pattern ="yyyy-MM-dd")
	//@dateOfApplication(message = "dateOfApplication must be greater than today")
	private LocalDate dateOfApplication;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfIssue;
	
	private Double registrationCost;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expiryDate;
	private String status;	
	
	public VisaDetails() {
		super();
	}

	public VisaDetails(String visaId, UserDetails userId, PassportDetails passportId,
			@NotBlank(message = "required") String country, @NotBlank(message = "required") String occupation,
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

	public PassportDetails getPassportId() {
		return passportId;
	}

	public void setPassportId(PassportDetails passportId) {
		this.passportId = passportId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
