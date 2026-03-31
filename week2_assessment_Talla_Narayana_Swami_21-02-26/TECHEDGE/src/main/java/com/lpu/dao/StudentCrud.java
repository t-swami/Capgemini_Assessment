package com.lpu.dao;

import com.lpu.entities.Student;

public interface StudentCrud {
	void addStudent(Student s);
	void updateStudentEmail(int id, String newEmail);
	void deleteStudent(int id);
}
