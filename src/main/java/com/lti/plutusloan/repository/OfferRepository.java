package com.lti.plutusloan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.plutusloan.dto.EmiDTO;
import com.lti.plutusloan.entity.Offer;

@Repository
public class OfferRepository extends GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public List<Offer> fetchOfferList(EmiDTO emiDTO) {
		Query query = entityManager.createQuery(
				"Select offer from Offer as offer where offer.offerAmount<=:amount and offer.offerRateOfInterest<=:interest and offer.offerTenure<=:tenure");
		query.setParameter("amount", emiDTO.getPrincipal());
		query.setParameter("interest", emiDTO.getRateOfInterest());
		query.setParameter("tenure", emiDTO.getTenure());

		List<Offer> offerList = query.getResultList();
		return offerList;
	}

}
