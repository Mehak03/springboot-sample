package com.spring.hibernate.SpringMVCHibernateProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPLICANT")
public class Applicant {
	
	public Applicant(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="VISA")
	private String visaStatus;
	
	@Column(name="COUNTRY")
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVisaStatus() {
		return visaStatus;
	}
	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
