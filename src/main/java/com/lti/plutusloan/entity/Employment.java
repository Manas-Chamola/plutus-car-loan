package com.lti.plutusloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employment {

	@Id
	@GeneratedValue
	private int employmentId;

	private String employmentType;

	private double salary;

	private String accountType;

	@ManyToOne
	@JoinColumn(name = "registrationId")
	private Registration registrationUser;

	public int getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(int employmentId) {
		this.employmentId = employmentId;
	}

	public Registration getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(Registration registrationUser) {
		this.registrationUser = registrationUser;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
