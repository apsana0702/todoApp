package com.example.todoApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
@EnableScheduling
public class TodoAppApplication {
	private static Logger log= LoggerFactory.getLogger(TodoAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

}
