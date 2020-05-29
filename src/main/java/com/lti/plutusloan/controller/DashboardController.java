package com.lti.plutusloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.entity.Loan;
import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.service.ApplicationService;
import com.lti.plutusloan.service.LoanService;

@RestController
@CrossOrigin
public class DashboardController {

	@Autowired
	LoanService loanService;
	@Autowired
	ApplicationService applicationService;

	@RequestMapping(path = "/loan/{approval}", method = RequestMethod.GET)
	public List<Loan> getLoanDetails(@PathVariable("approval") String approval) {
		return loanService.getLoanDetails(approval);
	}

	@RequestMapping(path = "/application/{approval}/{loanId}", method = RequestMethod.PUT)
	public void updateApproval(@RequestBody @PathVariable("approval") String approval,
			@PathVariable("loanId") int loanId) {
		loanService.updateApproval(approval, loanId);
	}

	@RequestMapping(path = "/application/{emailId}", method = RequestMethod.GET)
	public Loan getUser(@PathVariable("emailId") String emailId) {
		Registration user = applicationService.fetchUserDetails(emailId);
		Loan loanDetails = loanService.getUser(user.getRegistrationId());
		return loanDetails;
	}

}
