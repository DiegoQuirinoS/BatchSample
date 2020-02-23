package com.example.demo.dto;

import com.example.demo.model.Person;

public class ObjectDTO implements DTO<PersonDTO>{

	private Person person;	
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public PersonDTO get() {		
		return new PersonDTO(person);
	}

}
