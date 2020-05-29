package com.lti.plutusloan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.plutusloan.dto.EligibilityDTO;
import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.service.EligibilityCheckService;
import com.lti.plutusloan.service.EmiCalculatorService;

@Service
public class EligibilityCheckServiceImp implements EligibilityCheckService {
	
	@Autowired
	EmiCalculatorService emiCalculatorService;

	public boolean checkEligibility(EligibilityDTO eligibilityDTO) {
		EmiDTO emiDTO = new EmiDTO();
		emiDTO.setPrincipal((int) eligibilityDTO.getAmount());
		emiDTO.setRateOfInterest(eligibilityDTO.getRateOfInterest());
		emiDTO.setTenure(eligibilityDTO.getTenure());
		double emi = emiCalculatorService.calculateEmi(emiDTO);
		if (emi < ((0.4 * 0.4 * eligibilityDTO.getYearlySalary() / 12) - eligibilityDTO.getExistingEmi())
				&& eligibilityDTO.getAge() + eligibilityDTO.getTenure() <= 58)
			return true;

		return false;
	}
}
