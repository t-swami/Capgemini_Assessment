package com.lpu.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.student.entity.Student;
import com.lpu.student.repository.StudentRepository;

@Service
public class StudentUserDetailsService  implements UserDetailsService{

	
	@Autowired
	private StudentRepository sturepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Student student = sturepo.findByEmail(email);
		return new  StudentUserDetails(student);
	
	}

}
