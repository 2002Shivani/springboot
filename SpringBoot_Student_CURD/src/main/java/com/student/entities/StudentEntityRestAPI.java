package com.student.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEntityRestAPI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
	private String studName;
	private String city;
	private String section;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public StudentEntityRestAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntityRestAPI(int studId, String studName, String city, String section) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.city = city;
		this.section = section;
	}
	@Override
	public String toString() {
		return "StudentEntityRestAPI [studId=" + studId + ", studName=" + studName + ", city=" + city + ", Section="
				+ section + "]";
	}
	
	

}
