package com.lti.plutusloan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.plutusloan.entity.Car;
import com.lti.plutusloan.repository.CarRepository;
import com.lti.plutusloan.service.CarService;

@Service
public class CarServiceImp implements CarService {

	@Autowired
	CarRepository carRepository;

	public List<String> fetchCarList() {
		List<String> carList = carRepository.fetchCarList();
		return carList;
	}

	public Car fetchCarData(String carName) {
		return carRepository.fetchCarData(carName);
	}
}
