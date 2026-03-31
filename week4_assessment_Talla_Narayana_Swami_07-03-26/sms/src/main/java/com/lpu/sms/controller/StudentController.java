package com.lpu.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.sms.entity.Student;
import com.lpu.sms.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestParam String name, 
			@RequestParam String email, @RequestParam String password,
			@RequestParam String course, @RequestParam String role, 
			@RequestParam int marks, @RequestParam MultipartFile assignmentFile, 
			@RequestParam MultipartFile profileImage) throws Exception {

		Student s = new Student();

		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCourse(course);
		s.setMarks(marks);
		s.setRole(role);

		s.setAssignmentFile(assignmentFile.getBytes());
		s.setProfileImage(profileImage.getBytes());
		

	    s.setProfileImageType(profileImage.getContentType());
	    s.setAssignmentFileType(assignmentFile.getContentType());

		return service.saveStudent(s);
	}

	@GetMapping("/find/{id}")
	public Student findById(@PathVariable Long id) {
		return service.findStudentById(id);
	}

	@GetMapping("/findall")
	public List<Student> findAllStudents(@RequestParam int pageNo, @RequestParam int size, @RequestParam String field) {
		return service.findAllaStudents(pageNo, size, field);
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable Long id, 
			@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String course, 
			@RequestParam String role,@RequestParam int marks, 
			@RequestParam MultipartFile assignmentFile,
			@RequestParam MultipartFile profileImage) throws Exception {

		Student s = new Student();

		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCourse(course);
		s.setMarks(marks);
		s.setRole(role);

		s.setAssignmentFile(assignmentFile.getBytes());
		s.setProfileImage(profileImage.getBytes());
		
		s.setProfileImageType(profileImage.getContentType());
		s.setAssignmentFileType(assignmentFile.getContentType());
		
		return service.updateStudent(id, s);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Student with id " + id + " deleted";
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<byte[]> getProfile(@PathVariable Long id){

	    Student s = service.findStudentById(id);

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"profile\"")
	            .header(HttpHeaders.CONTENT_TYPE, s.getProfileImageType())
	            .body(s.getProfileImage());
	}
	
	@GetMapping("/assignment/{id}")
	public ResponseEntity<byte[]> getAssignment(@PathVariable Long id){

	    Student s = service.findStudentById(id);

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"assignment\"")
	            .header(HttpHeaders.CONTENT_TYPE, s.getAssignmentFileType())
	            .body(s.getAssignmentFile());
	}
}
