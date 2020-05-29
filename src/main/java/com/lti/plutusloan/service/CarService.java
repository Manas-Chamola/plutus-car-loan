package com.lti.plutusloan.service;

import java.util.List;

import com.lti.plutusloan.entity.Car;

public interface CarService {

	public List<String> fetchCarList();
	
	public Car fetchCarData(String carName);
}
