package com.lti.plutusloan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.plutusloan.dto.RegistrationDTO;
import com.lti.plutusloan.entity.Registration;
import com.lti.plutusloan.repository.RegistrationRepository;
import com.lti.plutusloan.service.RegistrationService;

@Service
public class RegistrationServiceImp implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Transactional
	public boolean doRegistration(RegistrationDTO registrationDTO) {
		Registration registration = new Registration();
		registration.setFirstName(registrationDTO.getFirstName());
		registration.setLastName(registrationDTO.getLastName());
		registration.setAge(registrationDTO.getAge());
		registration.setGender(registrationDTO.getGender());
		registration.setMobile(registrationDTO.getMobile());
		registration.setEmailId(registrationDTO.getEmailId());
		registration.setPassword(registrationDTO.getPassword());
		registration.setAddress(registrationDTO.getAddress());
		registration.setCity(registrationDTO.getCity());
		registration.setState(registrationDTO.getState());
		registration.setPincode(registrationDTO.getPincode());
		registration.setRole(registrationDTO.getRole());
		registrationRepository.store(registration);
		return true;
	}

	public boolean checkRegistration(RegistrationDTO registrationDTO) {
		if (registrationRepository.checkRegistration(registrationDTO) != null)
			return true;
		else
			return false;
	}
}
