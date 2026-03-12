package com.lpu.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
@Component
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String trainer;
	
//	@ManyToMany
//	private List<Student> student;
	
	
	public Course() {
		
	}

	public Course(String name, String trainer) {
		super();
		this.name = name;
		this.trainer = trainer;
//		this.student = student;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

//	public List<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}
	

}
