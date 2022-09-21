package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class springbokDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(springbokDemoApplication.class, args);
	}

}
