package com.lpu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.sms.entity.Student;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT new com.lpu.sms.entity.Student(s.id, s.name, s.email, s.password, s.role) FROM Student s WHERE s.email = :email")
	Student findByEmail(@Param("email") String email);
}
