package com.lpu;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Delivery {
	@Id
	private int deliveryId;
	private String deliveryType;
	private String deliveryStatus;
	@OneToMany
	private List<Orders> orders;

}
