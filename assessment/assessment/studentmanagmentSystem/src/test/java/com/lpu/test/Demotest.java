package com.lpu.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.lpu.entity.Student;

public class Demotest {
	
	@Test
	public void demo1() {
		
		Assertions.assertEquals("xyz", "xyz");
	}
	
	@Test
	public void demo2() {
		Assertions.assertNotNull(null,"Values shold not be null");
	}
	
	@Test
	public void demo3() {
		Assertions.assertThrows(ArithmeticException.class, () ->{
			int res = 7/0;
		});
	}
	
//	@Test
//	public void demo4() {
//		
//		//if exception comes testcase pass
//		Assertions.assertDoesNotThrow(AithmeticException.class, () ->{
//			
//		}
//		
//				);
//	}
	@Test
	public void demo5() {
		String s1 = "ABC";
		String s2 = "ABC";
		
		//checks the memory adress same or not
		Assertions.assertSame(s1, s2);
	}
//	
//	@Test
//	public void demo6() {
//		Student s1 = new Student();
//		Student s2 = new Student();
//		//address same true or false 
//		Assertions.assertSame(s1, s2);
//	}
	
	
	
	@ParameterizedTest
	@CsvSource({"2,3,5", "10,20,30","15,-15,0"})
	public void demo8(int a,int b,int expected) {
		int res = a+b;
		Assertions.assertEquals(expected, res);
		
	}
	@BeforeAll
	public static void m1() {
		System.out.println("Before All");
	}
	@AfterAll
	public static void m2() {
		System.out.println("After All");
	}
	
	
	@BeforeEach
	public void m3() {
		System.out.println("Before each test case");
	}
	
	@AfterEach
	public void m4() {
		System.out.println("After each test case");
	}

}
