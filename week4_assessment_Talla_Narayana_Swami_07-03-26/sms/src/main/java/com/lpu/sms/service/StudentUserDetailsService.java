package com.lpu.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.sms.entity.Student;
import com.lpu.sms.repository.StudentRepository;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student s = repository.findByEmail(username);
		if(s==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new StudentUserDetails(s);
	}
}