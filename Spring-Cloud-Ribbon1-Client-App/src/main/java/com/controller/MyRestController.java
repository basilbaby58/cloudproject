package com.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
@RequestMapping("/client/frontend")
public String frontEnd() {
	URI uri = URI.create("http://productservercopy/productBackEnd");
	String res =this.restTemplate.getForObject(uri, String.class);
	return "Server Response: "+res;
}
}
