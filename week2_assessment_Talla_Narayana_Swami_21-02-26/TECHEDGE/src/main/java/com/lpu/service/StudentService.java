package com.lpu.service;

import com.lpu.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.StudentCrud;

@Component
public class StudentService {

	@Autowired
	private StudentCrud sc;

	public void addStudent(Student d) {

		sc.addStudent(d);
	}

	public void updateStudent(int studentId, String newEmail) {
		sc.updateStudentEmail(studentId, newEmail);

	}

	public void deleteStudent(int studentId) {
		sc.deleteStudent(studentId);
	}

}
