package com.joseph.www.dao;

import java.util.List;

import com.joseph.www.models.Student;


public interface StudentDao {
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List getAllStudent();
}
