package com.lti.plutusloan.dto;

import com.lti.plutusloan.entity.Employment;
import com.lti.plutusloan.entity.Loan;

public class SubmitDataContextDTO {

	private Loan loan;

	private Employment employment;

	private String emailId;

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
