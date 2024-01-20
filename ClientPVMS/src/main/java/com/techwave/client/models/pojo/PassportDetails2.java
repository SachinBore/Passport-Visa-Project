package com.techwave.client.models.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PassportDetails2 {

	public PassportDetails2() {
	}

	private String passportId;
	private UserDetails userId;
	private String country;

	private String state;

	private String city;
	private String typeOfService;//
	private String bookletType;//
	
	private String pin;

	private String reasonForReissue;//

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate issueDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	private Double cost;//
	private String status;//
	public PassportDetails2(String passportId, UserDetails userId, String country, String state, String city, String typeOfService,
			String bookletType, String pin, String reasonForReissue, LocalDate issueDate, LocalDate expiryDate,
			Double cost, String status) {
		super();
		this.passportId = passportId;
		this.userId = userId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.typeOfService = typeOfService;
		this.bookletType = bookletType;
		this.pin = pin;
		this.reasonForReissue = reasonForReissue;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.cost = cost;
		this.status = status;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTypeOfService() {
		return typeOfService;
	}
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}
	public String getBookletType() {
		return bookletType;
	}
	public void setBookletType(String bookletType) {
		this.bookletType = bookletType;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getReasonForReissue() {
		return reasonForReissue;
	}
	public void setReasonForReissue(String reasonForReissue) {
		this.reasonForReissue = reasonForReissue;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
