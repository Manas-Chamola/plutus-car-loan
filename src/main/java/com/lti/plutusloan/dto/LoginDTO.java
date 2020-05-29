package com.lti.plutusloan.dto;

public class LoginDTO {

	private String emailId;
	private String password;
	private int role;

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emilId) {
		this.emailId = emilId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
