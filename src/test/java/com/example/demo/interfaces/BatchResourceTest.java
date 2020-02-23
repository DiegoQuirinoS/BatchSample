package com.example.demo.interfaces;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.PersonService;
import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonResource.class)
public class BatchResourceTest {
	
	@MockBean
	private PersonService personService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetPersonByName() throws Exception {	
		Optional<PersonDTO> optional = Optional.of(new PersonDTO(new Person("diego", "silva")));
		Mockito.when(personService.getPersonByName(Mockito.anyString())).thenReturn(optional);
		mvc.perform(get("/api/person/diego").accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());		
	}

}
