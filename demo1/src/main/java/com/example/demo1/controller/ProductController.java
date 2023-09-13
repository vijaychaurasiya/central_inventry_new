package com.example.demo1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	@GetMapping("/products")
	public ResponseEntity<List<Object>> getProducts() throws Exception{
//		if(supplierDTO.getBaseUrl()==null || supplierDTO.getConsumerKey()==null || supplierDTO.getConsumerSecret()==null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    
//		}
		//String url=supplierDTO.getBaseUrl()+"products/?consumer_key="+supplierDTO.getConsumerKey()+"&consumer_secret="+supplierDTO.getConsumerSecret();
		String url="https://lafemmestore.in/wp-json/wc/v3/products/?consumer_key=ck_c11825bccd95fdc7546b314be6fded4a01f201f8&consumer_secret=cs_3082c4f850bbd3a522be6b119a01c070909417d7";
		//System.out.println(url);
		RestTemplate restTemplate=new RestTemplate();
		Object[] productList= restTemplate.getForObject(url, Object[].class);
		return new ResponseEntity<>(Arrays.asList(productList),HttpStatus.OK);
		
	}
}
