package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.EligibilityDTO;
import com.lti.plutusloan.service.EligibilityCheckService;

@RestController
@CrossOrigin
public class EligibilityController {

	@Autowired
	EligibilityCheckService eligibilityCheckService;

	@RequestMapping(path = "/eligibility/check", method = RequestMethod.POST)
	public String checkEligibility(@RequestBody EligibilityDTO eligibilityDTO) {

		boolean checkEligibility = eligibilityCheckService.checkEligibility(eligibilityDTO);

		if (checkEligibility) {
			return "{\"status\" : \"You are eligible!\"}";
		}

		return "{\"status\" : \"You are not eligible \"}";
	}

}
