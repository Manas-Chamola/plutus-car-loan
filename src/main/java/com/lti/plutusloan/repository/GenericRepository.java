package com.lti.plutusloan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public void store(Object object) {
		entityManager.merge(object);
	}

	public <E> E fetchById(Class<E> classname, Object primaryKey) {
		E e = entityManager.find(classname, primaryKey); // select query
		return e;
	}

	public <E> List<?> fetchAll(Class<E> classname) {
		Query q = entityManager.createQuery("select Obj from " + classname.getName() + " as Obj");
		return q.getResultList();
	}
}
