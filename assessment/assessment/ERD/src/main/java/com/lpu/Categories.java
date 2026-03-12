package com.lpu;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {
	@Id
	private int categoryId;
	private String categoryName;
	private String categoryType;
	@OneToMany
	private List<Products> products;

}
