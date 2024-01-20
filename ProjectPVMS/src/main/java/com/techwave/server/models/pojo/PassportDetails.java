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
@Table(name = "passport_details")
public class PassportDetails {

	@Id
	@Column(length = 10)
	private String passportId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userId;

	private String country;

	private String state;

	private String city;
	@Column(length = 15)
	private String typeOfService;
	@Column(length = 15)
	private String bookletType;

	@Column(length = 6)
	private String pin;

	private String reasonForReissue;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate issueDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	private Double cost;
	@Column(length = 10)
	private String status;

	public PassportDetails() {
		super();
	}

	public PassportDetails(String passportId, UserDetails userId, String country, String state, String city,
			String reasonForReissue, String typeOfService, String bookletType, LocalDate issueDate,
			LocalDate expiryDate, Double cost, String pin, String status) {
		super();
		this.passportId = passportId;
		this.userId = userId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.typeOfService = typeOfService;
		this.bookletType = bookletType;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.cost = cost;
		this.pin = pin;
		this.reasonForReissue = reasonForReissue;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
