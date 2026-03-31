package com.lpu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.lpu.entities.Department;
import com.lpu.entities.Student;

@Component
public class DepartmentCrudimp implements DepartmentCrud{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	@Override
	public void addSDepartment(Department d) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
	}
	
	@Override
	public void assignStudentToDepartment(int deptId, Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
        Department d1=em.find(Department.class, deptId);
        List<Student> l1=d1.getStudents();
        l1.add(student);
        d1.setStudents(l1);
		   et.begin();
		   em.merge(d1);
		   et.commit();
		
	}

	@Override
	public void updateDepartmentName(int id, String name) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d = em.find(Department.class, id);
		d.setName(name);
		et.begin();
		em.merge(d);
		et.commit();
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d = em.find(Department.class, id);
		et.begin();
		em.remove(d);
		et.commit();
		
	}

	@Override
	public List<Student> viewStudentsInDepartment(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d = em.find(Department.class, id);
		return d.getStudents();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		return em.find(Department.class, id);
	}

}
