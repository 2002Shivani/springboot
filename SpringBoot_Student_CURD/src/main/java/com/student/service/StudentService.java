package com.student.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.entities.StudentEntityRestAPI;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public String insertData(StudentEntityRestAPI s) {
		String msg =dao.insertData(s);
		return msg;
	}
	
	public String deleteData(int studId) {
		String msg =dao.deleteData(studId);
		return msg;
	}
	
	public String updateData(StudentEntityRestAPI s ,  int studId) {
		String msg =dao.updateData(s,studId);
		return msg;
	}
	
	public StudentEntityRestAPI getSingleRecord(int studId) {
		StudentEntityRestAPI  s = dao.getSingleRecord(studId);
		return s;
	}
	public List<StudentEntityRestAPI> getAllRecord() {
		List<StudentEntityRestAPI> s = dao.getAllRecord();
		return s;
	}
}
