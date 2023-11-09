package com.academia.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages= "com.academia.model")
@EnableJpaRepositories(basePackages = "com.academia.dao")
@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class},scanBasePackages = {"com.academia.controller","com.academia.service"})
public class Ejercicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

}
