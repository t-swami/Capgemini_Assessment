package com.lpu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.lpu.config.MyCongif;
import com.lpu.service.CourseService;

public class CourseController {
	
//	private static CourseService cs = new CourseService();
	
	public static void main(String[] args) {
		
		ApplicationContext context =
                new AnnotationConfigApplicationContext(MyCongif.class);
		 CourseService service = context.getBean(CourseService.class);
		
		service.registerCourse("Java", "ravi");
		
		
	}

}
