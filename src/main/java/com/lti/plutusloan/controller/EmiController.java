package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.service.EmiCalculatorService;

@RestController
@CrossOrigin
public class EmiController {

	@Autowired
	EmiCalculatorService emiCalculatorService;

	@RequestMapping(path = "/emi/calculate", method = RequestMethod.POST)
	public double calculateEmi(@RequestBody EmiDTO emiDTO) {
		double emi = emiCalculatorService.calculateEmi(emiDTO);
		return emi;
	}
}
