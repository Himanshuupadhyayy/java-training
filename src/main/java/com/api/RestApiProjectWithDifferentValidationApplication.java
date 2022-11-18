package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiProjectWithDifferentValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProjectWithDifferentValidationApplication.class, args);
		
		System.out.println("this is api projet");
	}
}