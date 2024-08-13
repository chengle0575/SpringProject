package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication //defines the main class of spring booot app

public class SpringFirstWebAppApplication {

	public static void main(String[] args) {

		var context=
		SpringApplication.run(SpringFirstWebAppApplication.class, args);
	}

}
