package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.RegistrationDTO;
import com.lti.plutusloan.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public String registerUser(@RequestBody RegistrationDTO registrationDTO) {

		if (!registrationService.checkRegistration(registrationDTO)) {
			if (registrationService.doRegistration(registrationDTO)) {
				return "{\"status\" : \"Registration done successfully!\"}";
			}
		}

		return "{\"status\" : \"Sorry! Registration Unsuccessful!\"}";

	}

}
