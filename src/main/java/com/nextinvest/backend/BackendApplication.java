package com.nextinvest.backend;

import com.nextinvest.backend.model.User;
import com.nextinvest.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args); // <--- Make sure this says .class
	}

	@Bean
	CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			User admin = userRepository.findByUsername("admin").orElse(new User());
			
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("password"));
			admin.setRole("ADMIN");
			
			userRepository.save(admin);
			System.out.println("------------------------------------------------");
			System.out.println(" ADMIN USER READY: username='admin' | password='password'");
			System.out.println("------------------------------------------------");
		};
	}
}