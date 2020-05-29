package com.lti.plutusloan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.plutusloan.dto.LoginDTO;
import com.lti.plutusloan.repository.LoginRepository;
import com.lti.plutusloan.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	public boolean validateUser(LoginDTO loginLoanDTO) {
		if (loginRepository.fetchUser(loginLoanDTO) != null)
			return true;

		return false;

	}

}
