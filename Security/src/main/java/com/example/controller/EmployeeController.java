package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/dashboard")
	public String dash() {
		return "Dashboard";
	}
	
	@GetMapping("/home")
	public String hm() {
		return "Welcome Home";
	}
	
	@GetMapping("/loging")
	public String loginn() {
		return "Login Page";
	}
}
