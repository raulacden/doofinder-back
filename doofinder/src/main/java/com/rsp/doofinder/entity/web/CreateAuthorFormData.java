package com.rsp.doofinder.entity.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateAuthorFormData {
	
	

	@NotNull
    @Size(min = 1, max = 400)
    private String name;

    @NotNull
    @Size(min = 1, max = 4)
    private String yearBirth;
    
    @NotNull
    @Size(min = 1, max = 4)
    private String yearDeath;

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

	/**
	 * @return the yearBirth
	 */
	public String getYearBirth() {
		return yearBirth;
	}

	/**
	 * @param yearBirth the yearBirth to set
	 */
	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	/**
	 * @return the yearDeath
	 */
	public String getYearDeath() {
		return yearDeath;
	}

	/**
	 * @param yearDeath the yearDeath to set
	 */
	public void setYearDeath(String yearDeath) {
		this.yearDeath = yearDeath;
	}
	
    public AuthorCreationParameters toParameters() {
        return new AuthorCreationParameters(name, yearBirth, yearDeath);
    }

}
