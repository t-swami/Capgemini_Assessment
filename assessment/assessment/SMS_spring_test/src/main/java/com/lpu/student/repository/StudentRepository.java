package com.lpu.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lpu.student.entity.Student;

import io.lettuce.core.dynamic.annotation.Param;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
	
	Student findByEmail(String email);
//	
//	@Query("SELECT s FROM Student s WHERE s.email = :email")
//	Student findByEmail(@Param("email") String email);
}
