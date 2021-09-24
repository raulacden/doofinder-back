package com.rsp.doofinder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsp.doofinder.entity.Book;
import com.rsp.doofinder.repository.IBookRepo;

@RestController
public class BookController {
	
	@Autowired
	IBookRepo bookRepo;
	
	
	//Save new book
	@PostMapping("/book")
	public ResponseEntity<Book> save(@RequestBody Book book) {
		try {
			return new ResponseEntity<>(bookRepo.save(book), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Obtain all the books
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllbooks() {
		try {
			List<Book> list = bookRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Obtain info from book
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getSinglebook(@PathVariable Long id) {
		Optional<Book> book = bookRepo.findById(id);
		
		if (book.isPresent()) {
			return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	//Update book	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updatebook(@RequestBody Book book) {
		
		try {
			return new ResponseEntity<Book>(bookRepo.save(book), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete book
	@DeleteMapping("/book/{id}")
	public ResponseEntity<HttpStatus> deletebook(@PathVariable Long id) {
		try {
			Optional<Book> book = bookRepo.findById(id);
			if (book.isPresent()) {
				bookRepo.delete(book.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
