package com.example.demo.dto;

import com.example.demo.model.Person;

public class PersonDTO {

	public PersonDTO() {	
	}

	public PersonDTO(Person person) {
		this.fullName = person.getName() + " " +person.getLastName();
	}
	
	private String fullName;
	
	public String getFullName() {
		return this.fullName;
	}

}
