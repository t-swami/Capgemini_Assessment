package com.bookstore.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookstore.orderservice.dto.BookDTO;

@FeignClient(name="bookservice", path = "/api/books")
public interface BookServiceClient {

	@PostMapping
	public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO book);
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findBookById(@PathVariable long id);
	
	@GetMapping
	public List<BookDTO> findBooks();
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBookById(@PathVariable long id, @RequestBody BookDTO book);
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> deleteBook(@PathVariable long id);
}
