package com.lti.plutusloan.service;

import com.lti.plutusloan.dto.LoginDTO;

public interface LoginService {

	public boolean validateUser(LoginDTO loginLoanDTO);
}
