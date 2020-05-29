package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.SubmitDataContextDTO;
import com.lti.plutusloan.service.LoanService;

@RestController
@CrossOrigin
public class LoanController {

	@Autowired
	LoanService loanService;

	@CrossOrigin
	@RequestMapping(path = "/submit", method = RequestMethod.POST)
	public String loanSubmit(@RequestBody SubmitDataContextDTO dataContextDTO) {
		loanService.submitLoan(dataContextDTO.getLoan(), dataContextDTO.getEmployment(), dataContextDTO.getEmailId());
		return "{\"status\" : \"Loan Submitted Successfully!\"}";

	}
}
