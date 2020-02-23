package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.ObjectDTO;

@Configuration
public class CustomConfiguration {

	public ObjectDTO objectDTO() {
		return new ObjectDTO();
	}
}
