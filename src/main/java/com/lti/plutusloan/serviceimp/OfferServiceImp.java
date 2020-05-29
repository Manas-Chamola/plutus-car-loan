package com.lti.plutusloan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.entity.Offer;
import com.lti.plutusloan.repository.OfferRepository;

import com.lti.plutusloan.service.OfferService;

@Service
public class OfferServiceImp implements OfferService {

	@Autowired
	private OfferRepository offerRepository;

	public List<Offer> fetchOfferList(EmiDTO emiDTO) {
		return offerRepository.fetchOfferList(emiDTO);
	}

}
