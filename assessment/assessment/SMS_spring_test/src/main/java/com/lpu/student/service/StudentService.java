package com.lpu.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.student.entity.Student;
import com.lpu.student.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sturepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	//save student
//	@PreAuthorize("hasRole('ADMIN')")
	public Student addStudent(Student student) {
		String encodedPassword = encoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		return sturepo.save(student);
	}
	
	//find by id
	@Cacheable(value = "students",key="#id")
	@PostAuthorize("returnObject.email == authentication.name or hasRole('ADMIN')")
	public Student findByid(int id) {
		System.out.println("From databse:");
		return sturepo.findById(id).orElseThrow();
	}
	
	
	//list of students
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> findAllStudents(int pageNumber, int pageSize,String field) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(field).descending());
		return sturepo.findAll(pageable).getContent();
	}
	
	
	//update student
	 public Student updateStudent(int id, Student student) {

	        Student existingStudent = sturepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

	        existingStudent.setName(student.getName());
	        existingStudent.setCourse(student.getCourse());

	        return sturepo.save(existingStudent);
	    }
	

	//delete student
	 @PreAuthorize("hasRole('ADMIN')")
	public void delete(int id) {
		 sturepo.deleteById(id);
	}
	
	
}


