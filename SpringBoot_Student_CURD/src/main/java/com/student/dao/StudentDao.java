package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.entities.StudentEntityRestAPI;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(StudentEntityRestAPI s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		tr.commit();
		ss.close();

		return "Data Inserted";
	}

	public String deleteData(int studId) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntityRestAPI s = ss.get(StudentEntityRestAPI.class, studId);
		ss.remove(s);
		tr.commit();
		ss.close();
		return "Data Deleted";
	}

	public String updateData(StudentEntityRestAPI s, int studId) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntityRestAPI s1 = ss.get(StudentEntityRestAPI.class, studId);
		s1.setStudName(s.getStudName());
		s1.setCity(s.getCity());
		s1.setSection(s.getSection());
		
		ss.merge(s1);
		tr.commit();
		ss.close();

		return "Data is updated";
	}
	
	public StudentEntityRestAPI getSingleRecord(int studId) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = "from StudentEntityRestAPI where studId =:studId";
		Query<StudentEntityRestAPI> query = ss.createQuery(hqlquery,StudentEntityRestAPI.class);
		query.setParameter("studId",studId);
		StudentEntityRestAPI s =  query.getSingleResult();
		tr.commit();
		ss.close();
		return s;
		
	}
	
	public List<StudentEntityRestAPI> getAllRecord(){
		
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = "from StudentEntityRestAPI";
		Query<StudentEntityRestAPI> query = ss.createQuery(hqlquery,StudentEntityRestAPI.class);
		List<StudentEntityRestAPI> s  = query.getResultList();
		tr.commit();
		ss.close();
		return s;
	}
}
