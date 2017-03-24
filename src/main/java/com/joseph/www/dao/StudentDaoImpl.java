package com.joseph.www.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.joseph.www.models.Student;

public class StudentDaoImpl implements StudentDao {
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Student student) {
		em.persist(student);
	}

	@Override
	public void edit(Student student) {
		em.merge(student);
	}

	@Override
	public void delete(int studentId) {	
		Student s = new Student();
		s = em.find(Student.class, studentId);
		em.remove(s);
	}

	@Override
	public Student getStudent(int studentId) {
		return em.find(Student.class, studentId);
	}

	@Override
	public List getAllStudent() {
		Query req = em.createQuery("select s from Student s");
		return req.getResultList();
	}

}
