package com.rsp.doofinder.entity.web;

import org.springframework.util.Assert;

public class AuthorCreationParameters {
	
	private final String name;
    private final String yearBirth;
    private final String yearDeath;

    public AuthorCreationParameters(String name, String yearBirth, String yearDeath) {
        Assert.notNull(name, "name should not be null");
        Assert.notNull(yearBirth, "yearBirth should not be null");
        Assert.notNull(yearDeath, "yearDeath should not be null");
        this.name = name;
        this.yearBirth = yearBirth;
        this.yearDeath = yearDeath;
    }

    public String getName() {
        return name;
    }

    public String getYearBirth() {
        return yearBirth;
    }
    
    public String getYearDeath() {
        return yearDeath;
    }

}
