package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.controller.PersonService;
import com.example.demo.dto.PersonDTO;


@RestController
@RequestMapping("api")
public class PersonResource {

	@Autowired
	private PersonService personService;	
	
	@GetMapping(path = "/person/{name}")
	public ResponseEntity<PersonDTO> getPersonByName(@PathVariable("name") String name) {		
		Optional<PersonDTO> optional = personService.getPersonByName(name);
		PersonDTO personDTO = optional
					.orElseThrow(() -> 
							new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));
		return new ResponseEntity<PersonDTO>(personDTO, HttpStatus.OK);		
	}
	
}
