package com.lti.plutusloan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.plutusloan.entity.Car;

@Repository
public class CarRepository extends GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public List<String> fetchCarList() {
		Query query = entityManager.createQuery("Select carList.carModel from Car as carList");
		List<String> carList = query.getResultList();
		return carList;
	}

	public Car fetchCarData(String carName) {
		Query query = entityManager.createQuery("Select cardata  from Car as cardata where cardata.carModel=:carName");
		query.setParameter("carName", carName);

		if (query.getResultList().size() > 0)
			return (Car) query.getResultList().get(0);

		return null;
	}
}
