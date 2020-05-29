package com.lti.plutusloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.entity.Car;
import com.lti.plutusloan.service.CarService;

@RestController
@CrossOrigin
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping(path = "/loan/carList", method = RequestMethod.GET)
	public List<String> carList() {
		return carService.fetchCarList();
	}

	@RequestMapping(path = "/carLoan/{carModel}", method = RequestMethod.GET)
	public Car carPrice(@PathVariable("carModel") String carModel) {
		return carService.fetchCarData(carModel);
	}

}
