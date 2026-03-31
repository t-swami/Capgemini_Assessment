package com.lpu.sms.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.sms.entity.Student;
import com.lpu.sms.exception.ResourceNotFoundException;
import com.lpu.sms.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repository;
	private final PasswordEncoder passwordEncoder;
	
	public StudentService(StudentRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@CachePut(value = "student", key = "#result.id")
	public Student saveStudent(Student student) {
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return repository.save(student);
	}
	
	@PostAuthorize("returnObject.email == authentication.name")
	@Cacheable(value = "student", key = "#id")
	public Student findStudentById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> findAllaStudents(int pageNo, int size, String field){
		Pageable pageable = PageRequest.of(pageNo, size, Sort.by(field).ascending());
		return repository.findAll(pageable).getContent();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@CachePut(value = "student", key = "#id")
	public Student updateStudent(Long id, Student s) {
		Student s1 = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
		
		s1.setAssignmentFile(s.getAssignmentFile());
		s1.setCourse(s.getCourse());
		s1.setEmail(s.getEmail());
		s1.setMarks(s.getMarks());
		s1.setName(s.getName());
		s1.setProfileImage(s.getProfileImage());
		s1.setRole(s.getRole());
		s1.setPassword(passwordEncoder.encode(s.getPassword()));
		
		return repository.save(s1);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@CacheEvict(value = "student", key = "#id")
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}

    public byte[] getProfileImage(Long id) {
        Student student = findStudentById(id);
        return student.getProfileImage();
    }

    public byte[] getAssignmentFile(Long id) {
        Student student = findStudentById(id);
        return student.getAssignmentFile();
    }
}
