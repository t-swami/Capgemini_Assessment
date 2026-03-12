package com.lpu;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	@Id
	private int productId;
	private String product_name;
	private int orderId;
	private int cateogryId;
	@ManyToMany
	private List<Orders> orders;
	@ManyToOne
	private Categories categorie;
	

}
