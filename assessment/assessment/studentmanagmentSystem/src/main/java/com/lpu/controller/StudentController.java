package com.lpu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.config.MyCongif;
import com.lpu.entity.Course;
import com.lpu.entity.Student;
import com.lpu.service.CourseService;
import com.lpu.service.StudentService;
//import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

public class StudentController {
	
	
	static ApplicationContext context =new AnnotationConfigApplicationContext(MyCongif.class);
	 static StudentService Stuserv = context.getBean(StudentService.class);
	 
		static ApplicationContext context1 =new AnnotationConfigApplicationContext(MyCongif.class);
		static  CourseService corserv = context1.getBean(CourseService.class);
	 
	 
//	private static StudentService Stuserv = new StudentService();
//	private static CourseService corserv   = new CourseService();
	
	public static void main(String[] args) {
//		StuService.registerStudent("pavan", 29, 98.0);
//		StuService.updateMarks(1, 55.55);
//		StuService.deleteStudent(1);
		Stuserv.assignCourse(1, 2);
		
		
		Course c1 = corserv.registerCourse("Java Fullstack", "chandan");
        Course c2 = corserv.registerCourse("Spring Boot", "Suresh");
        
        Student s1 = Stuserv.registerStudent("Vignan", 22, 88);
        Student s2 = Stuserv.registerStudent("xyz", 21, 90);
       
        Stuserv.assignCourse(s1.getId(), c1.getId());
        Stuserv.assignCourse(s1.getId(), c2.getId());
        
        Stuserv.assignCourse(s2.getId(), c1.getId());
        System.out.println("Courses Assigned Successfully");
	}

}
