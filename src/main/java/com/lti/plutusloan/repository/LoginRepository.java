package com.lti.plutusloan.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.plutusloan.dto.LoginDTO;
import com.lti.plutusloan.entity.Registration;

@Repository
public class LoginRepository extends GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public Registration fetchUser(LoginDTO loginDTO) {

		Query query = entityManager.createQuery(
				"Select user from Registration as user where user.emailId=:emailId and user.password=:password and user.role=:role");
		query.setParameter("emailId", loginDTO.getEmailId());
		query.setParameter("password", loginDTO.getPassword());
		query.setParameter("role", loginDTO.getRole());

		if (query.getResultList().size() > 0)
			return (Registration) (query.getResultList().get(0));

		return null;

	}
}
