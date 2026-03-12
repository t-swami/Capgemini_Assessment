package com.lpu.student.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.student.entity.Student;
import com.lpu.student.repository.StudentRepository;
import com.lpu.student.service.StudentFileService;
import com.lpu.student.service.StudentService;

import jakarta.validation.constraints.DecimalMax;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService stuservice;  // for curd operations of student
	@Autowired
	private StudentRepository sturepo;  //for Repository
	@Autowired
	private StudentFileService fileservice;  // for performing the file upload,download operations
	
	
	
	
	//save or create  student
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return stuservice.addStudent(student);
	}
	
	//findAll list of student and added  with pagination(page_number,size,field for sorting)
	@GetMapping("/findAll/{pagenumber}/{size}/{field}")
	public List<Student> pagenation(@PathVariable int pagenumber,@PathVariable int size,@PathVariable String field){
		return stuservice.findAllStudents(pagenumber, size,field);
	}
	
	
	//find stu by id

	@GetMapping("find/{id}")
	public Student findBYID(@PathVariable int id) {
		return stuservice.findByid(id);
	}
	
	
	//delete the student record by id
	@DeleteMapping("/delete/{id}")
	public void Delete(@PathVariable int id) {
		stuservice.delete(id);
	}
	
	//update by id and set the name and course
	@PutMapping("/update/{id}")
	public Student updateStu(@PathVariable int id,@RequestBody Student student) {
		return stuservice.updateStudent(id, student);
	}
	
	//file upload
	@PostMapping("/upload/{id}")
	public String upload(@PathVariable int id,
	                     @RequestParam(required = false) MultipartFile image,
	                     @RequestParam(required = false) MultipartFile file) throws IOException {

	    return fileservice.uploadFiles(id, image, file);
	}

	
	//download the image
	@GetMapping("/download/image/{id}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable int id) {

	    byte[] image = fileservice.downloadImage(id);

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=profile.jpg")
	            .contentType(MediaType.IMAGE_JPEG)
	            .body(image);
	}
	

	//download the file
	@GetMapping("/download/file/{id}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {

	    byte[] file = fileservice.downloadFile(id);

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=assignment.pdf")
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(file);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
