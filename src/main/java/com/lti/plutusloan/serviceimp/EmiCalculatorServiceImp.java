package com.lti.plutusloan.serviceimp;

import org.springframework.stereotype.Service;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.service.EmiCalculatorService;

@Service
public class EmiCalculatorServiceImp implements EmiCalculatorService {

	public double calculateEmi(EmiDTO emiDTO) {
		double emi = ((emiDTO.getPrincipal() * (emiDTO.getRateOfInterest() / (12 * 100)))
				* (Math.pow(1 + (emiDTO.getRateOfInterest() / (12 * 100)), 12 * emiDTO.getTenure())
						/ ((Math.pow(1 + (emiDTO.getRateOfInterest() / (12 * 100)), 12 * emiDTO.getTenure()) - 1))));
		return Math.round(emi * 100.0) / 100.0;
	}
}
