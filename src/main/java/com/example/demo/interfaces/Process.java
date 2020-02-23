package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.controller.BatchService;
import com.example.demo.controller.PersonService;
import com.example.demo.dto.PersonDTO;


@RestController
@RequestMapping("api")
public class Process {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private BatchService batchService;
	
	@GetMapping(path = "/person/{name}")
	public ResponseEntity<PersonDTO> getPersonByName(@PathVariable("name") String name) {		
		Optional<PersonDTO> optional = personService.getPersonByName(name);
		PersonDTO personDTO = optional
					.orElseThrow(() -> 
							new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));
		return new ResponseEntity<PersonDTO>(personDTO, HttpStatus.OK);		
	}
	
	@PostMapping("/process")
	public void process() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {		
		batchService.process();
	}
}
