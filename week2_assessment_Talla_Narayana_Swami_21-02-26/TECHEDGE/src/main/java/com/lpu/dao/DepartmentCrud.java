package com.lpu.dao;

import java.util.List;

import com.lpu.entities.Department;
import com.lpu.entities.Student;

public interface DepartmentCrud {
	void addSDepartment(Department d);
	void updateDepartmentName(int id, String name);
	void deleteDepartment(int id);
	List<Student> viewStudentsInDepartment(int id);
	Department getDepartmentById(int id);
	void assignStudentToDepartment(int id, Student s);
}
