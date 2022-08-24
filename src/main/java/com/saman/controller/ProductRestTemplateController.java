package com.saman.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saman.model.Product;

@RestController
public class ProductRestTemplateController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/template/products")
	public String getProductList() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("http://localhost:443/products", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value="/template/products",method=RequestMethod.POST)
	public String createProduct(@RequestBody Product product) {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<>(product,header);
		
		return  restTemplate.exchange("http://localhost:443/products", HttpMethod.POST,entity,String.class).getBody();
		
	}

}
