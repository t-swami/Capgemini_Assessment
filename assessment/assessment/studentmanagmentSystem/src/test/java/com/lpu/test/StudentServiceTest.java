package com.lpu.test;

import org.junit.jupiter.api.Assertions;

import com.lpu.service.StudentService;

public class StudentServiceTest {
	static StudentService ss = new StudentService();
	
	public static void main(String[] args) {
		
		boolean res = ss.equals(ss);
		Assertions.assertEquals(res,0);
		
		
	}

}
