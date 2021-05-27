package com.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.pms.model.Product;

@RestController
@RequestMapping("/anotherms")
public class MyRestContoller {
	
	URI uri = URI.create("http://localhost:8085/getDataFromCloud");
	URI productGetUri = URI.create("http://localhost:8082/product");
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public ResponseEntity<String> getHi(){
		ResponseEntity<String> res = restTemplate.getForEntity(uri, String.class);
		return res;
	}
	
	@GetMapping()
	public ResponseEntity<Product[]> getProduct(){
		ResponseEntity<Product[]> res = restTemplate.getForEntity(productGetUri, Product[].class);
		return res;
	}
	
	@PostMapping()
	public  ResponseEntity<String> createProduct(@RequestBody Product product){
		 ResponseEntity<String> res = restTemplate.postForEntity(productGetUri, product, String.class);
		 return res;
	}
	
	@PutMapping()
	public String updateProduct(@RequestBody Product product){
		  restTemplate.put(productGetUri, product);
		  return "data updated successfully";
	}
	
	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable("id") Integer id) {
		  String pId =id.toString();
		  restTemplate.delete(productGetUri+"/"+pId);
		  return "data Deleted successfully";
		
	}



	
}
