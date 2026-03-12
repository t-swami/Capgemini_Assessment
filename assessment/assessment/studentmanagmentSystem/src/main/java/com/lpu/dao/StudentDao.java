package com.lpu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class StudentDao {
	
//	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	@Autowired
	private  EntityManagerFactory emf;
	
	public Student saveStudent(Student s) {
		
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
		return s;
	}
	
	public Student findStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class,id);
		em.close();
		return s;
		
	}
	public void updateStudentMarks(int id,double newMarks) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s =findStudentById(id);
		et.begin();
		if(s!=null) {
			s.setMarks(newMarks);
			em.merge(s);
		}

		et.commit();
		em.close();
		
	}
	public void deleteStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		
		et.begin();
		em.remove(s);
		et.commit();
		em.close();
		
		
	}
	public void assignCourseToStudent(int studentId, int courseId) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    et.begin();

	    Student student = em.find(Student.class, studentId);
	    Course course = em.find(Course.class, courseId);

	    if (student != null && course != null) {

	        List<Course> courses = student.getCourse();

	        if (courses == null) {
	            courses = new ArrayList<>();
	        }

	        courses.add(course);
	        student.setCourse(courses);

	        em.merge(student);
	    }

	    et.commit();
	    em.close();
	}
	

}
