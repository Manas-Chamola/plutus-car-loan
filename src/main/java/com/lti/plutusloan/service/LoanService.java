package com.lti.plutusloan.service;

import java.util.List;

import com.lti.plutusloan.entity.Employment;
import com.lti.plutusloan.entity.Loan;

public interface LoanService {

	public List<Loan> getLoanDetails(String approval);

	public Loan getUser(int registrationId);

	public void submitLoan(Loan loan, Employment employment, String emailId);

	public void updateApproval(String approval, int loanId);

}
