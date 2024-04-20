package com.app.ordenaly;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition
public class OrdenalyApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrdenalyApplication.class, args);
	}

}
