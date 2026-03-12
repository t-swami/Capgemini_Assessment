package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.DepartmentDao;
import dao.StudentDao;
import entity.Department;
import entity.Student;

@Component
	public class StudentService {

	    @Autowired
	    private StudentDao studentDAO;

	    @Autowired
	    private DepartmentDao departmentDAO;

	    public void addStudent(Student student) {
	        studentDAO.addStudent(student);
	    }

	    // ⭐ Business Logic Method
	    public void assignStudentToDepartment(int deptId, Student student) {

	        Department dept = departmentDAO.getDepartmentById(deptId);
	        student.setDepartment(dept);

	        studentDAO.addStudent(student);
	    }

	    public List<Student> viewStudentsByDepartment(int deptId) {
	        return studentDAO.viewStudentsByDepartment(deptId);
	    }

	    public void updateStudent(int studentId, String newEmail) {
	        studentDAO.updateStudent(studentId, newEmail);
	    }

	    public void deleteStudent(int studentId) {
	        studentDAO.deleteStudent(studentId);
	    }
	}


