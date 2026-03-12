package com.lpu;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	private int orderId;
	private String orderDate;
	private int deliveryId;
	
	private int customerId;
	@ManyToOne
	private Customers customers;
	@ManyToMany
	private  List<Products> product;
	@ManyToOne
	private Delivery delivery;
	
	

}
