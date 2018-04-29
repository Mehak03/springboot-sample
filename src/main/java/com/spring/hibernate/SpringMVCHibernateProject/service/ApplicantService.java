package com.spring.hibernate.SpringMVCHibernateProject.service;

import java.util.List;

import com.spring.hibernate.SpringMVCHibernateProject.model.Applicant;

public interface ApplicantService {
	int addApplicant(Applicant user);
	List<Applicant> getApplicants();
	void updateApplicantDetails(Applicant user);
}
