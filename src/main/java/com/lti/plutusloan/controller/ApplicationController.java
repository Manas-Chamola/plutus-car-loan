package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.service.ApplicationService;

@RestController
@CrossOrigin
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;

	@RequestMapping(path = "/personal/{emailId}", method = RequestMethod.GET)
	public Registration fetchPersonalDetails(@PathVariable("emailId") String emailId) {
		return applicationService.fetchUserDetails(emailId);
	}
}
