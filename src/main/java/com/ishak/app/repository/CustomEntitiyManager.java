package com.ishak.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public class CustomEntitiyManager {
	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return (Session) getEntityManager().unwrap(Session.class);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
