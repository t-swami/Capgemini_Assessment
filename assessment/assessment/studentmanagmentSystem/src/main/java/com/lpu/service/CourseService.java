package com.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CourseDao;
import com.lpu.dao.StudentDao;
import com.lpu.entity.Course;
import com.lpu.entity.Student;
@Component
public class CourseService {
	
@Autowired
private CourseDao Dao ;//dependency injection
	

	public  Course registerCourse(String name,String trainer) {
		Course cc= new Course(name,trainer);
		
		return Dao.saveCourse(cc);
	}
				
		
		 
		 
		
	
	//method-2
	public Course getCourse(int id) {
		Course c = Dao.findCourseById(id);
		if(c == null) {
			throw new IllegalArgumentException("Course not found");
			
		}
		return c;
	}
	public Course updateCourse(int id, String newName, String newTrainer) {

	    Course c = Dao.findCourseById(id);

	    if(c == null) {
	        throw new IllegalArgumentException("Course not found");
	    }

	    if(newName != null && !newName.isEmpty()) {
	        c.setName(newName);
	    }

	    if(newTrainer != null && !newTrainer.isEmpty()) {
	        c.setTrainer(newTrainer);
	    }

	    Dao.updateCourseName(id,newName);
	    return c;
	}


	
	public void deleteCourse(int id) {
		 
		        getCourse(id);  // ensures course exists
		        Dao.deleteCourseById(id);
		    }
	
	
	

	

}
