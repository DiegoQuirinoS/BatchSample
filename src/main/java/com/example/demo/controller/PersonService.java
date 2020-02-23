package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Optional<PersonDTO> getPersonByName(String name) {	
		
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		Person person = personRepository.findByName(name);
		Optional<PersonDTO> optional = Optional.of(new PersonDTO(person));
		return optional;
	}
}
