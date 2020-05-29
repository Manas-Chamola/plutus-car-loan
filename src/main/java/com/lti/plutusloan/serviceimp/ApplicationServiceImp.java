package com.lti.plutusloan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.repository.ApplicationRepository;
import com.lti.plutusloan.service.ApplicationService;

@Service
public class ApplicationServiceImp implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;

	public Registration fetchUserDetails(String emailId) {
		return applicationRepository.fetchUserDetails(emailId);
	}

}
