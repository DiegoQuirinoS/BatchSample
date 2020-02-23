package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	
	private Logger log = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    
	public void process()  {
		try {
			jobLauncher.run(job, new JobParameters());	
		}catch(JobExecutionException e) {
			log.error("Error executing batch", e);
		}
	}

}
