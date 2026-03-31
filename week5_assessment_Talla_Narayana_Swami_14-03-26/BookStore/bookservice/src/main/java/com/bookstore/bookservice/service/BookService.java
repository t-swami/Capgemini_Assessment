package com.bookstore.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public Book saveBook(Book book) {
		return repository.save(book);
	}
	
	public Book findBook(long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public List<Book> findBooks() {
		return repository.findAll();
	}
	
	public Book updateBook(long id, Book book) {

	    Book b = repository.findById(id).orElse(null);

	    if (b == null) {
	        throw new RuntimeException("Book not found with id: " + id);
	    }

	    b.setAuthor(book.getAuthor());
	    b.setCategory(book.getCategory());
	    b.setIsbn(book.getIsbn());
	    b.setPrice(book.getPrice());
	    b.setQuantity(book.getQuantity());
	    b.setTitle(book.getTitle());

	    return repository.save(b);
	}
	
	public void deleteBook(long id) {
		repository.deleteById(id);
	}
}
