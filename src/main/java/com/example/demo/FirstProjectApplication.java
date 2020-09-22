package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"com.example.demo.model"})
public class FirstProjectApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
