package com.rsp.doofinder.entity.web;

import org.springframework.util.Assert;

public class BookCreationParameters {
	
	private final String title;
    private final String description;
    private final String yearPublication;
    private final Long author;
    private final Long genre;

    public BookCreationParameters(String title, String description, String yearPublication, Long author, Long genre) {
        Assert.notNull(title, "title should not be null");
        Assert.notNull(description, "description should not be null");
        Assert.notNull(yearPublication, "yearPublication should not be null");
        Assert.notNull(author, "author should not be null");
        Assert.notNull(genre, "genre should not be null");
        this.title = title;
        this.description = description;
        this.yearPublication = yearPublication;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public String getYearPublication() {
        return yearPublication;
    }
    
    public Long getAuthor() {
        return author;
    }
    
    public Long getGenre() {
        return genre;
    }

}
