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

import com.rsp.doofinder.entity.Author;
import com.rsp.doofinder.repository.IAuthorRepo;

@RestController
public class AuthorController {
	

	@Autowired
	IAuthorRepo authorRepo;
	
	@PostMapping("/author")
	public ResponseEntity<Author> save(@RequestBody Author Author) {
		try {
			return new ResponseEntity<>(authorRepo.save(Author), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAllAuthors() {
		try {
			List<Author> list = authorRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Author>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getSingleAuthor(@PathVariable Long id) {
		Optional<Author> Author = authorRepo.findById(id);
		
		if (Author.isPresent()) {
			return new ResponseEntity<Author>(Author.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author Author) {
		
		try {
			return new ResponseEntity<Author>(authorRepo.save(Author), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Long id) {
		try {
			Optional<Author> Author = authorRepo.findById(id);
			if (Author.isPresent()) {
				authorRepo.delete(Author.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
