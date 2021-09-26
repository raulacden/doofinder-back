package com.rsp.doofinder.entity.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rsp.doofinder.entity.Author;
import com.rsp.doofinder.entity.Book;
import com.rsp.doofinder.entity.Genre;
import com.rsp.doofinder.repository.IAuthorRepo;
import com.rsp.doofinder.repository.IBookRepo;
import com.rsp.doofinder.repository.IGenreRepo;


@Controller
public class WebController {
	
	@Autowired
	IAuthorRepo authorRepo;
	
	@Autowired
	IBookRepo bookRepo;
	
	@Autowired
	IGenreRepo genreRepo;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/webAuthors")
	public ModelAndView webAuthors() {
		
		ModelAndView mav = new ModelAndView("authors");		
        mav.addObject("authors", authorRepo.findAll());
        mav.addObject("author", new CreateAuthorFormData());
        
        return mav;
	}
	@PostMapping("/webAuthors/create")
	public ModelAndView webAuthorsNew( @Valid @ModelAttribute("formData") CreateAuthorFormData formData,
            BindingResult bindingResult,
            Model model) {
		
		ModelAndView mav = new ModelAndView("authors");	
		
		if (bindingResult.hasErrors()) {
			mav.setViewName("/");
            return mav;
        }
		
		Author author = new Author();		
		author.setName(formData.toParameters().getName());
		author.setYearBirth(formData.toParameters().getYearBirth());
		author.setYearDeath(formData.toParameters().getYearDeath());
		
		
		authorRepo.save(author);
		
		
        mav.addObject("authors", authorRepo.findAll());
        mav.addObject("author", new CreateAuthorFormData());
        
        return mav;
	}
	
	@GetMapping("/webAuthors/delete/{id}")
	public ModelAndView webAuthorsDelete(@PathVariable(value = "id") Long id) {
		

		ModelAndView mav = new ModelAndView("authors");	        
		
		Optional<Author> Author = authorRepo.findById(id);
		if (Author.isPresent()) {
			authorRepo.delete(Author.get());
		}
			
		mav.addObject("authors", authorRepo.findAll());
        mav.addObject("author", new CreateAuthorFormData());
        
        return mav;
	}
	
	@GetMapping("/webBooks")
	public ModelAndView webBooks() {
		
		ModelAndView mav = new ModelAndView("books");		
        mav.addObject("books", bookRepo.findAll());
        mav.addObject("book", new CreateBookFormData());
        mav.addObject("listAuthors", authorRepo.findAll());
        mav.addObject("listGenres", genreRepo.findAll());
        
        return mav;
	}
	
	@PostMapping("/webBooks/create")
	public ModelAndView webBooksNew( @Valid @ModelAttribute("formData") CreateBookFormData formData,
            BindingResult bindingResult,
            Model model) {
		
		ModelAndView mav = new ModelAndView("books");	
		
		if (bindingResult.hasErrors()) {
			mav.setViewName("/");
            return mav;
        }
		
		Book book = new Book();		
		book.setTitle(formData.toParameters().getTitle());
		book.setDescription(formData.toParameters().getDescription());
		book.setYearPublication(formData.toParameters().getYearPublication());
		book.setAuthor(authorRepo.getById(formData.toParameters().getAuthor()));
		book.setGenre(genreRepo.getById(formData.toParameters().getGenre()));
		
		bookRepo.save(book);
		
        mav.addObject("books", bookRepo.findAll());
        mav.addObject("book", new CreateBookFormData());
        
        return mav;
	}
	
	@GetMapping("/webBooks/delete/{id}")
	public ModelAndView webBooksDelete(@PathVariable(value = "id") Long id) {
		

		ModelAndView mav = new ModelAndView("books");        
		
		Optional<Book> Book = bookRepo.findById(id);
		if (Book.isPresent()) {
			bookRepo.delete(Book.get());
		}
			
		mav.addObject("books", bookRepo.findAll());
        mav.addObject("book", new CreateBookFormData());
        
        return mav;
	}
	
	@GetMapping("/webGenres")
	public ModelAndView webGenre() {

		ModelAndView mav = new ModelAndView("genres");		
        mav.addObject("genres", genreRepo.findAll());
        mav.addObject("listGenres", genreRepo.findAll());
        mav.addObject("genre", new CreateGenreFormData());
        
        return mav;
	}
	
	@PostMapping("/webGenres/create")
	public ModelAndView webGenresNew( @Valid @ModelAttribute("formData") CreateGenreFormData formData,
            BindingResult bindingResult,
            Model model) {
		
		ModelAndView mav = new ModelAndView("genres");	
		
		if (bindingResult.hasErrors()) {
			mav.setViewName("/");
            return mav;
        }
		
		Genre genre = new Genre();

		genre.setName(formData.toParameters().getName());
		
		genreRepo.save(genre);
		
        mav.addObject("genres", genreRepo.findAll());
        mav.addObject("genre", new CreateGenreFormData());
        
        return mav;
	}
	
	@GetMapping("/webGenres/delete/{id}")
	public ModelAndView webGenresDelete(@PathVariable(value = "id") Long id) {
		

		ModelAndView mav = new ModelAndView("genres");        
		
		Optional<Genre> Genre = genreRepo.findById(id);
		if (Genre.isPresent()) {
			genreRepo.delete(Genre.get());
		}
			
		mav.addObject("genres", genreRepo.findAll());	
        mav.addObject("genre", new CreateAuthorFormData());	
        
        return mav;
	}

}
