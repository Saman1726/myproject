package com.saman.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class PrductServiceInterceptorAppConfig implements WebMvcConfigurer{
	
	@Autowired
	ProductServiceInterceptor productServiceInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(productServiceInterceptor);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/products").allowedOrigins("http;//localhost:443");
	}

}
