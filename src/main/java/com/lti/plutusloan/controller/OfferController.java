package com.lti.plutusloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.entity.Offer;
import com.lti.plutusloan.service.OfferService;

@RestController
@CrossOrigin
public class OfferController {

	@Autowired
	OfferService offerService;

	@RequestMapping(path = "/offers", method = RequestMethod.POST)
	public List<Offer> fetchOffers(@RequestBody EmiDTO emiDTO) {
		return offerService.fetchOfferList(emiDTO);
	}

}
