package com.example.demo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.BatchService;


@RestController
@RequestMapping("batch")
public class BatchResource {
	
	@Autowired
	private BatchService batchService;
	
	@PostMapping("/process")
	public void process() {		
		batchService.process();
	}
}
