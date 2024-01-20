package com.techwave.server.models.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_Authentication")
public class AuthenticationService {
	@Id
	private String username;
    private LocalDateTime timestamp;
    public AuthenticationService() {
	}
	public AuthenticationService(String username, LocalDateTime timestamp) {
		super();
		this.username = username;
		this.timestamp = timestamp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
}
