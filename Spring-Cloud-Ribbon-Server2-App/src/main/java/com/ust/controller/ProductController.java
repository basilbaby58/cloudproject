package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/")
	public String index() {
		return "Product App-Home Page";
	}
	
	@GetMapping("/productBackEnd")
	public String productBackEnd() {
		
		String serverPort = environment.getProperty("local.server.port");
		System.out.println("###Inside ProductController backend,Respose from SERVER2 ::: "+serverPort);
		return "Hello from ProductController -Backend, Host: localhost , port :"+serverPort;
	}


}
