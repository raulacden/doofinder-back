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

import com.rsp.doofinder.entity.Genre;
import com.rsp.doofinder.repository.IGenreRepo;

public class GenreController {
	
	@Autowired
	IGenreRepo genreRepo;
	
	
	//Save new genre
	@PostMapping("/genre")
	public ResponseEntity<Genre> save(@RequestBody Genre genre) {
		try {
			return new ResponseEntity<>(genreRepo.save(genre), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Obtain all the genres
	@GetMapping("/genre")
	public ResponseEntity<List<Genre>> getAllgenres() {
		try {
			List<Genre> list = genreRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Genre>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Genre>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Obtain info from genre
	@GetMapping("/genre/{id}")
	public ResponseEntity<Genre> getSinglegenre(@PathVariable Long id) {
		Optional<Genre> genre = genreRepo.findById(id);
		
		if (genre.isPresent()) {
			return new ResponseEntity<Genre>(genre.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Genre>(HttpStatus.NOT_FOUND);
	}
	
	//Update genre	
	@PutMapping("/genre/{id}")
	public ResponseEntity<Genre> updategenre(@RequestBody Genre genre) {
		
		try {
			return new ResponseEntity<Genre>(genreRepo.save(genre), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete genre
	@DeleteMapping("/genre/{id}")
	public ResponseEntity<HttpStatus> deletegenre(@PathVariable Long id) {
		try {
			Optional<Genre> genre = genreRepo.findById(id);
			if (genre.isPresent()) {
				genreRepo.delete(genre.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
