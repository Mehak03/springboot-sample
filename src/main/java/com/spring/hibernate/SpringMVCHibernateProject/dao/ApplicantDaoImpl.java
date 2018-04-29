package com.spring.hibernate.SpringMVCHibernateProject.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.SpringMVCHibernateProject.model.Applicant;

@Repository
public class ApplicantDaoImpl implements ApplicantDao, InitializingBean {

	
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory entityManager;
	
	@Override
	public int addApplicant(Applicant user) {
		System.out.println("sessionFac::" + sessionFactory);
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			tx = session.getTransaction();
			tx.commit();
		}catch(Exception ex){
			System.err.println("exception: " + ex);
			if(tx != null){
				tx.rollback();
			}
		}
		return user.getId();
	}
	
	@Override
	public List<Applicant> getApplicants() {
		System.out.println("inside getApplicantById::");
		Session session = null;
		Transaction tx = null;
		List<Applicant> userList = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			userList = session.createQuery("from Applicant").list();
			tx = session.getTransaction();
		}catch(Exception ex){
			System.err.println("exception: " + ex);
			if(tx != null){
				tx.rollback();
			}
		}
		
		return userList;
	}
	
	@Override
	public void updateApplicantDetails(Applicant user) {
		System.out.println("sessionFac::" + sessionFactory);
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			tx = session.getTransaction();
			tx.commit();
		}catch(Exception ex){
			System.err.println("exception: " + ex);
			if(tx != null){
				tx.rollback();
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("entityManager:::" + entityManager);
		if(entityManager.unwrap(SessionFactory.class) == null){ 
			throw new NullPointerException("Factory is not a hibernate factory");
		}

		this.sessionFactory = entityManager.unwrap(SessionFactory.class);
	}

}
