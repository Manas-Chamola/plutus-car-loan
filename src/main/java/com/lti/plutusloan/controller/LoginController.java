package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.LoginDTO;
import com.lti.plutusloan.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestBody LoginDTO loginDTO) {

		boolean isValidUser = loginService.validateUser(loginDTO);

		if (isValidUser) {
			return "{\"status\" : \"Login successfully!\"}";
		}

		return "{\"status\" : \"Login Unsuccessful!\"}";

	}

}
