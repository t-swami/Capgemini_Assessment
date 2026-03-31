package com.lpu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.lpu.entities.Student;

@Component
public class StudentCrudimp implements StudentCrud{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

	@Override
	public void addStudent(Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		// TODO Auto-generated method stub
		et.begin();
		em.persist(s);
		et.commit();
		
	}

	@Override
	public void updateStudentEmail(int id, String newEmail) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		// TODO Auto-generated method stub
		Student s = em.find(Student.class, id);
		s.setEmail(newEmail);
		et.begin();
		em.merge(s);
		et.commit();
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		
		et.begin();
		em.remove(s);
		et.commit();
		
	}
}
