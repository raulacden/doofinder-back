package com.rsp.doofinder.entity.web;

import org.springframework.util.Assert;

public class GenreCreationParameters {
	
	private final String name;

    public GenreCreationParameters(String name) {
        Assert.notNull(name, "name should not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }   

}
