package com.bookstore.bookservice.controller;

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

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.service.BookService;

@RequestMapping("/api/books")
@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBook(book));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable long id) {
		Book book = service.findBook(id);
		
		if (book != null) {
            return ResponseEntity.ok(book);
        }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping
	public List<Book> findBooks() {
		return service.findBooks();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody Book book) {
		return ResponseEntity.ok(service.updateBook(id, book));
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> deleteBook(@PathVariable long id) {
		service.deleteBook(id);
		
		return ResponseEntity.noContent().build();
	}
}
