package com.techwave.client.models.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDetails {

	private String userId;
	private String citizenType;
	
	

	
	@Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Name should only contain letters and spaces")
	private String firstName;
	
	@Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Name should only contain letters and spaces")
	private String surname;

	@PastOrPresent(message = "DOB cannot be greater than today's date.")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate dateOfBirth;

	private String gender;

	
	@Pattern(regexp = "^[A-Za-z0-9\\s\\-.,']+$", message = "Invalid Address Format")
	@Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters.")
	private String address;

	@Pattern(regexp = "^[0-9]{10}$", message = "Contact number must contain exactly 10 digits.")
	private String contactNo;

	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid Email")
	private String emailAddress;

	private String qualification;

	private String applyType;
	
	private String hintQuestion;
	
	@Size(min = 5, max = 100, message = "Hint Answer must be between 5 and 100 characters.")
	private String hintAnswer;


	public UserDetails() {
		super();
	}

	public UserDetails(String firstName, String surname, LocalDate dateOfBirth, String gender, String address,
			String contactNo, String emailAddress, String qualification, String applyType, String hintQuestion,
			String hintAnswer, String userId, String citizenType) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
		this.qualification = qualification;
		this.applyType = applyType;
		this.hintQuestion = hintQuestion;
		this.hintAnswer = hintAnswer;
		this.userId = userId;
		this.citizenType = citizenType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getHintQuestion() {
		return hintQuestion;
	}

	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}

	public String getHintAnswer() {
		return hintAnswer;
	}

	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCitizenType() {
		return citizenType;
	}

	public void setCitizenType(String citizenType) {
		this.citizenType = citizenType;
	}
}
