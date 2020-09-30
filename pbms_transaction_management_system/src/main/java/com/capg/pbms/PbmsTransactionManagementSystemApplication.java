package com.capg.pbms;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PbmsTransactionManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbmsTransactionManagementSystemApplication.class, args);
		System.out.println("transactions Management");
	}
	
	@Bean 
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public Random getRandom()
	{
		return new Random();
	}

}
