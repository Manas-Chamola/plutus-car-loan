package com.lti.plutusloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {
	@Id
	@GeneratedValue
	int offerId;

	int offerAmount;

	double offerRateOfInterest;

	int offerTenure;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}

	public double getOfferRateOfInterest() {
		return offerRateOfInterest;
	}

	public void setOfferRateOfInterest(double offerRateOfInterest) {
		this.offerRateOfInterest = offerRateOfInterest;
	}

	public int getOfferTenure() {
		return offerTenure;
	}

	public void setOfferTenure(int offerTenure) {
		this.offerTenure = offerTenure;
	}

}
