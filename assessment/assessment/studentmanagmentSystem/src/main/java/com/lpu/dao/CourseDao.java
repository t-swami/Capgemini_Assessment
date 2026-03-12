package com.lpu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class CourseDao {
	
	
//private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	@Autowired
	private  EntityManagerFactory emf;//Dependency injection
	
	public Course saveCourse(Course c) {
		
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
		return c;
	}
	
	
	public Course findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c = em.find(Course.class,id);
		em.close();
		return c;
		
	}
	public void updateCourseName(int id,String newName) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c=findCourseById(id);
		et.begin();
		if(c!=null) {
			c.setName(newName);
			
			em.merge(c);
		}

		et.commit();
		em.close();
		
	}
	public void deleteCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c = em.find(Course.class, id);
		
		et.begin();
		em.remove(c);
		et.commit();
		em.close();
		
		
	}

}
