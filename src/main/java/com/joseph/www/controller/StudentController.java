package com.joseph.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseph.www.metier.IStudentMetier;
import com.joseph.www.metier.StudentMetierImpl;
import com.joseph.www.models.Student;


@Controller
public class StudentController {
//	@Autowired
//	private StudentService studentService;
	
	@Autowired
	private IStudentMetier metierStudent = new StudentMetierImpl();
	
	@RequestMapping({"/index", "/"})
	public String setupForm(Map<String, Object> map){
		System.out.println("index");
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", metierStudent.getAllStudent());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		
		if(action.equals("add")){
			metierStudent.add(student);
			studentResult = student;
		}
		else if(action.equals("edit")){
			metierStudent.edit(student);
			studentResult = student;
		}
		else if(action.equals("delete")){
			metierStudent.delete(student.getStudentId());
			studentResult = new Student();
		}
		else if(action.equals("search")){
			Student searchedStudent = metierStudent.getStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
		}
		
		map.put("student", studentResult);
		map.put("studentList", metierStudent.getAllStudent());
		return "student";
	}
}
