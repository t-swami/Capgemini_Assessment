package com.lpu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "com.lpu")
public class MyCongif {
	
	@Bean
	public EntityManagerFactory getemf() {
		return Persistence.createEntityManagerFactory("dev");
		
	}
	

}
