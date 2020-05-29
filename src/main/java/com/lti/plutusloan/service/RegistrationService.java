package com.lti.plutusloan.service;

import com.lti.plutusloan.dto.RegistrationDTO;

public interface RegistrationService {

	public boolean doRegistration(RegistrationDTO registrationDTO);

	public boolean checkRegistration(RegistrationDTO registrationDTO);
}
