package com.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.StudentDao;
import com.lpu.entity.Student;
@Component
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	
	public Student registerStudent(String name,int age,double marks) {
		
		if(age<18 || age>100) {
			throw new IllegalArgumentException("Invalid age");
		}
		if(marks<0 || marks>100) {
			throw new IllegalArgumentException("Invalid marks");
			
		}
		 Student s = new Student(name,age,marks);
		 
		return dao.saveStudent(s);
		}
	
	//method-2
	public Student getStudent(int id) {
		Student s = dao.findStudentById(id);
		if(s == null) {
			throw new IllegalArgumentException("Student not found");
			
		}
		return s;
	}
	//method-3
	public void updateMarks(int id,double newMarks) {
		if(newMarks <0 || newMarks >100) {
			throw new IllegalArgumentException("Invalid marks");
		}
//		getStudent(id);
		dao.updateStudentMarks(id, newMarks);
	}
	public void deleteStudent(int id) {
//		getStudent(id);
		dao.deleteStudentById(id);
	}
	
	public void assignCourse(int studentId, int courseId) {
	    dao.assignCourseToStudent(studentId, courseId);
	}

}
