package com.saman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringbootProjectApplication implements ApplicationRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(SpringbootProjectApplication.class);
	
	@Value("${spring.application.name:DemoService}")
	private String name;
	
	@Value("${java.io.tempdir}")
	private String tempdir;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments arg0) {
		logger.info("this is new new info!");
		logger.warn("this is new warn!");
		System.setProperty("java.io.tempdir", tempdir);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public String hello() {
		return name;
	}

	public String helloSam() {
		return "Hello SAMAN World!";
	}
	

}
