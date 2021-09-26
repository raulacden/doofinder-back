package com.rsp.doofinder.entity.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateBookFormData {
	
	

	@NotNull
    @Size(min = 1, max = 400)
    private String title;

    @NotNull
    @Size(min = 1, max = 400)
    private String description;
    
    @NotNull
    @Size(min = 1, max = 4)
    private String yearPublication;
    
    @NotNull
    private Long author;
    
    @NotNull
    private Long genre;

    
	
    /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the yearPublication
	 */
	public String getYearPublication() {
		return yearPublication;
	}



	/**
	 * @param yearPublication the yearPublication to set
	 */
	public void setYearPublication(String yearPublication) {
		this.yearPublication = yearPublication;
	}



	/**
	 * @return the author
	 */
	public Long getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(Long author) {
		this.author = author;
	}



	/**
	 * @return the genre
	 */
	public Long getGenre() {
		return genre;
	}



	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Long genre) {
		this.genre = genre;
	}



	public BookCreationParameters toParameters() {
        return new BookCreationParameters(title, description, yearPublication, author, genre );
    }

}
