package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonServiceTest {

	@Autowired
	PersonService personService;
	
	@Test
	void shouldFail_withoutName() {
		assertThrows(IllegalArgumentException.class, () -> personService.getPersonByName(null));
	}

}
