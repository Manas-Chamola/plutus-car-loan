package com.lti.plutusloan.service;

import java.util.List;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.entity.Offer;

public interface OfferService {

	public List<Offer> fetchOfferList(EmiDTO emiDTO);
	
}
