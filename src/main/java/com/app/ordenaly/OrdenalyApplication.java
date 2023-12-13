package com.app.ordenaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OrdenalyApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrdenalyApplication.class, args);
	}

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	// GENERA LA CONTRASEÑA
//	@Bean
//	public CommandLineRunner createPassword() {
//		return args -> {
//			System.out.println(passwordEncoder.encode("qwerty"));
//			System.out.println(passwordEncoder.encode("ytrewq"));
//		};
//	}

}
