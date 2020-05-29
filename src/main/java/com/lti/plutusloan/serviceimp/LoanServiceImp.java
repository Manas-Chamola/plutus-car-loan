package com.lti.plutusloan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.plutusloan.entity.Employment;
import com.lti.plutusloan.entity.Loan;
import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.repository.ApplicationRepository;
import com.lti.plutusloan.repository.LoanRepository;
import com.lti.plutusloan.service.LoanService;

@Service
public class LoanServiceImp implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ApplicationRepository applicationRepository;

	public List<Loan> getLoanDetails(String approval) {
		return loanRepository.getLoanDetails(approval);
	}

	@Transactional
	public void updateApproval(String approval, int loanId) {
		loanRepository.updateApproval(approval, loanId);
	}

	public Loan getUser(int registrationId) {
		Loan loan = loanRepository.fetchById(Loan.class, registrationId);
		return loan;
	}

	@Transactional
	public void submitLoan(Loan loan, Employment employment, String emailId) {
		Registration registration = new Registration();
		registration = applicationRepository.fetchUserDetails(emailId);

		Loan loanApplication = new Loan();
		loanApplication.setRegistration(registration);
		loanApplication.setApproval("P");
		loanApplication.setAmount(loan.getAmount());
		loanApplication.setEmi(loan.getEmi());
		loanApplication.setExistingEmi(loan.getExistingEmi());
		loanApplication.setRateOfInterest(loan.getRateOfInterest());
		loanApplication.setTenure(loan.getTenure());

		Employment employmentDetails = new Employment();
		employmentDetails.setRegistrationUser(registration);
		employmentDetails.setAccountType(employment.getAccountType());
		employmentDetails.setEmploymentType(employment.getEmploymentType());
		employmentDetails.setSalary(employment.getSalary());

		loanRepository.store(loanApplication);
		loanRepository.store(employmentDetails);
	}

}
