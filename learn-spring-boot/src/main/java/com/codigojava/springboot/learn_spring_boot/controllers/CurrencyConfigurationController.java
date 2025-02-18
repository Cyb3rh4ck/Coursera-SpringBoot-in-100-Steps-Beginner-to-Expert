package com.codigojava.springboot.learn_spring_boot.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codigojava.springboot.learn_spring_boot.configurations.CurrencyServiceConfiguration;
import com.codigojava.springboot.learn_spring_boot.models.Course;

@RestController
public class CurrencyConfigurationController {

	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@GetMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveAllConfiguration() {
		return configuration;
	}

}
