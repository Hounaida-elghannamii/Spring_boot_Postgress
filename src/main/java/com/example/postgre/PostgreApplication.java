package com.example.postgre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgreApplication.class, args);
		System.out.println("hi");
	}

}
