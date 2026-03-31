package com.lpu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.entities.Department;
import com.lpu.entities.Student;
import com.lpu.myconfig.MyConfig;
import com.lpu.service.DepartmentServices;
import com.lpu.service.StudentService;

public class DepartmentController {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
		
		DepartmentServices ds = ac.getBean("departmentServices", DepartmentServices.class);
		
		StudentService ss = ac.getBean("studentService", StudentService.class);
		
		List<Student> ls = new ArrayList<>();
		Department d = new Department();
		d.setId(101);
		d.setName("art");
		
		Department d1 = new Department();
		d1.setId(102);
		d1.setName("finance");
		ds.addDepartment(d);
		ds.addDepartment(d1);
		
		Student s = new Student();
		s.setId(1);
		s.setName("rishi");
		s.setEmail("iudhs");
		s.setDepartment(d);
		
		Student s1 = new Student();
		s1.setId(2);
		s1.setName("raju");
		s1.setEmail("esawhs");
		s1.setDepartment(d);
		
		Student s2 = new Student();
		s2.setId(3);
		s2.setName("poori");
		s2.setEmail("dfddvs");
		s2.setDepartment(d1);
		
		ss.addStudent(s);
		ss.addStudent(s2);
		ss.addStudent(s1);
		
		List<Student> ls1 = new ArrayList<>();
		
		ls.add(s);
		ls.add(s1);
		
		ls1.add(s2);
		
		d.setStudents(ls);
		
		d1.setStudents(ls1);
		
	}
}
