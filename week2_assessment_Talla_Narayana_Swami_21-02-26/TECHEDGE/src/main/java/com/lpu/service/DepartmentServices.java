package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.DepartmentCrud;
import com.lpu.entities.Department;
import com.lpu.entities.Student;

@Component
public class DepartmentServices {

	   @Autowired
	   private DepartmentCrud dc;
	   
	   public void addDepartment(Department d) {
		     dc.addSDepartment(d);
	   }
	   
	   public void updateDepartmentNmae(int id, String newName) {
		   dc.updateDepartmentName(id, newName);
	   }
	   
	   public void assignStudentToDepartment(int deptId, Student student) {
		     dc.assignStudentToDepartment(deptId, student);
	   }
	   
	  
	   public Department getDepartmentById(int deptId) {
	   		
		   return dc.getDepartmentById(deptId);
	   	}

	 
	   	public List<Student> view(int deptId) {
	   		
	   		  return dc.viewStudentsInDepartment(deptId);
	   	}

	  
	   	public void deleteDepartment(int deptId) {
	   		
	   		dc.deleteDepartment(deptId);
	   		
	   	}

	  

}
