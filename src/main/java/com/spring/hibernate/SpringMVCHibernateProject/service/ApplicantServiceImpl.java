package com.spring.hibernate.SpringMVCHibernateProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.SpringMVCHibernateProject.dao.ApplicantDao;
import com.spring.hibernate.SpringMVCHibernateProject.model.Applicant;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantDao applicant;
	
	@Override
	@Transactional
	public int addApplicant(Applicant user) {
		System.out.println("applicant::" + applicant);
		return applicant.addApplicant(user);
		
	}

	@Override
	public List<Applicant> getApplicants() {
		System.out.println("getApplicants::");
		return applicant.getApplicants();
	}
	
	@Override
	@Transactional
	public void updateApplicantDetails(Applicant user) {
		System.out.println("updateApplicantDetails::" + applicant);
		applicant.updateApplicantDetails(user);
		
	}

}
