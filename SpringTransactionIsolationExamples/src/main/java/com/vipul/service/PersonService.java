package com.vipul.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	public void defaultIsolation() throws SQLException {
		LOGGER.info("Isolation level in defaultIsolation is: {}",
				((SessionImpl) this.entityManager.unwrap(Session.class)).connection().getTransactionIsolation());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public void readCommitted() throws SQLException {
		LOGGER.info("Isolation level in readCommitted is: {}",
				((SessionImpl) this.entityManager.unwrap(Session.class)).connection().getTransactionIsolation());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	public void readUnCommitted() throws SQLException {
		LOGGER.info("Isolation level in readUnCommitted is: {}",
				((SessionImpl) this.entityManager.unwrap(Session.class)).connection().getTransactionIsolation());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	public void repeatableRead() throws SQLException {
		LOGGER.info("Isolation level in repeatableRead is: {}",
				((SessionImpl) this.entityManager.unwrap(Session.class)).connection().getTransactionIsolation());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public void serializable() throws SQLException {
		LOGGER.info("Isolation level in serializable is: {}",
				((SessionImpl) this.entityManager.unwrap(Session.class)).connection().getTransactionIsolation());
	}

	private ApplicationContext applicationContext;
	private EntityManager entityManager;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		this.entityManager = this.applicationContext.getBean(EntityManager.class);
	}

}
