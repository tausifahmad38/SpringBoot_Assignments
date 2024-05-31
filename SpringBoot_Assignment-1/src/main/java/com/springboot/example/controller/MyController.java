package com.springboot.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("/bank-name")
	public String showName() {
		return "Bank of India";
	}
	
	@RequestMapping("/bank-address")
	public String showAdress() {
		return "Delhi";
	}

}
