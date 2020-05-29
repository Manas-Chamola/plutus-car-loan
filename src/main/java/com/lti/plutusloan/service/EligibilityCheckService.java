package com.lti.plutusloan.service;

import com.lti.plutusloan.dto.EligibilityDTO;

public interface EligibilityCheckService {

	public boolean checkEligibility(EligibilityDTO eligibilityDTO);
}
