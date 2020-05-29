package com.lti.plutusloan.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.plutusloan.entity.Registration;

@Repository
public class ApplicationRepository extends GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public Registration fetchUserDetails(String emailId) {

		Query query = entityManager.createQuery("Select data from Registration as data where data.emailId=:emailId");
		query.setParameter("emailId", emailId);
		if (query.getResultList().size() > 0)
			return (Registration) query.getResultList().get(0);

		return null;
	}
}
