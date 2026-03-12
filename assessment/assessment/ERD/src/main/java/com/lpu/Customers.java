package com.lpu;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customers {
	@Id
	private  int id;
	private String name;
	private String email;
	private String address;
	@OneToMany
	private List<Orders> order;
	
	

}
