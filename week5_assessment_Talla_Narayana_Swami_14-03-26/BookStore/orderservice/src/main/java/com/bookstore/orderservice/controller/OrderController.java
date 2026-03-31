package com.bookstore.orderservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.orderservice.client.BookServiceClient;
import com.bookstore.orderservice.dto.BookDTO;
import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.service.OrderService;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@Autowired 
	private BookServiceClient client;
	
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

	    BookDTO book = client.findBookById(order.getBookId()).getBody();

	    if (book == null) {
	        throw new RuntimeException("Book not found with id: " + order.getBookId());
	    }

	    order.setTotalPrice(book.getPrice() * order.getQuantity());
	    order.setOrderDate(LocalDate.now());
	    order.setStatus("Placed");

	    return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrder(order));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable long id) {
		Order order = service.findOrder(id);
		
		if (order != null) {
            return ResponseEntity.ok(order);
        }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping
	public List<Order> findOrders() {
		return service.findOrders();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrderById(@PathVariable long id, @RequestBody Order order) {

	    BookDTO book = client.findBookById(order.getBookId()).getBody();

	    if (book == null) {
	        throw new RuntimeException("Book not found with id: " + order.getBookId());
	    }

	    order.setTotalPrice(book.getPrice() * order.getQuantity());
	    order.setOrderDate(LocalDate.now());
	    order.setStatus("Placed");

	    return ResponseEntity.ok(service.updateOrder(id, order));
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> deleteOrderById(@PathVariable long id) {
		service.deleteOrder(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
