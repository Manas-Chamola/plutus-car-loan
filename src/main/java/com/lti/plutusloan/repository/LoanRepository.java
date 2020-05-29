package com.lti.plutusloan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.plutusloan.entity.Loan;
import com.lti.plutusloan.service.ApplicationService;

@Repository
public class LoanRepository extends GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public List<Loan> getLoanDetails(String approval) {
		Query query = entityManager.createQuery("select user from Loan as user where user.approval=:approval");
		query.setParameter("approval", approval);

		return query.getResultList();
	}

	public List<Loan> fetchAll() {
		Query query = entityManager.createQuery("Select  user from Loan as user");
		return query.getResultList();
	}

	public void updateApproval(String approval, int loanId) {

		Query query = entityManager.createQuery("update Loan l set l.approval=:approval where l.loanId=:loanId");
		query.setParameter("loanId", loanId);
		query.setParameter("approval", approval);
		query.executeUpdate();
	}

}
