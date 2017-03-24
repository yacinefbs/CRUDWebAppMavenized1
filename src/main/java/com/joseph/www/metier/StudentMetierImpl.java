package com.joseph.www.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.joseph.www.dao.StudentDao;
import com.joseph.www.dao.StudentDaoImpl;
import com.joseph.www.models.Student;


@Transactional
public class StudentMetierImpl implements IStudentMetier {


	private StudentDao daoStudent = new StudentDaoImpl();
	
	
	

	public void setDaoStudent(StudentDao daoStudent) {
		this.daoStudent = daoStudent;
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		daoStudent.add(student);
	}

	@Override
	public void edit(Student student) {
		// TODO Auto-generated method stub
		daoStudent.edit(student);
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		daoStudent.delete(studentId);
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return daoStudent.getStudent(studentId);
	}

	@Override
	public List getAllStudent() {
		// TODO Auto-generated method stub
		return daoStudent.getAllStudent();
	}

}
