package com.spring.hibernate.SpringMVCHibernateProject.dao;

import java.util.List;

import com.spring.hibernate.SpringMVCHibernateProject.model.Applicant;

public interface ApplicantDao {
	int addApplicant(Applicant user);
	List<Applicant> getApplicants();
	void updateApplicantDetails(Applicant user);
}
