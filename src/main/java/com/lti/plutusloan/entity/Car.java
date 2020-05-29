package com.lti.plutusloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue
	private int carId;

	private String carModel;

	private String carMake;

	private double exShowroomPrice;

	private double onRoadPrice;

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public double getExShowroomPrice() {
		return exShowroomPrice;
	}

	public void setExShowroomPrice(double exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}

	public double getOnRoadPrice() {
		return onRoadPrice;
	}

	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

}
