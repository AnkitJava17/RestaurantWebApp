package com.buddy.foodManagement.model;

import java.util.HashMap;
import java.util.Map;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// @Entity
@Document
public class Food {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private String name;
    private String description;

	public Food() {}
    
	public Food( String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
