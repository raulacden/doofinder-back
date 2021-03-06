package com.rsp.doofinder.entity.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateGenreFormData {
	
	

	@NotNull
    @Size(min = 1, max = 400)
    private String name;
    

    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
    public GenreCreationParameters toParameters() {
        return new GenreCreationParameters(name);
    }

}
