package com.lti.plutusloan.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.plutusloan.dto.RegistrationDTO;
import com.lti.plutusloan.entity.Registration;

@Repository
public class RegistrationRepository extends GenericRepository {
	@PersistenceContext
	protected EntityManager entityManager;

	public Registration checkRegistration(RegistrationDTO registrationDTO) {
		Query query = entityManager.createQuery("Select user from Registration as user where user.emailId=:emailId");
		query.setParameter("emailId", registrationDTO.getEmailId());
		if (query.getResultList().size() > 0)
			return (Registration) query.getResultList().get(0);

		return null;

	}

}
