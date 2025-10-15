package com.palhotel.sweet_shop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SweetShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetShopBackendApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Check if an admin user already exists
			if (userRepository.findByUsername("admin").isEmpty()) {
				User adminUser = new User();
				adminUser.setUsername("admin");
				// Hash the password before saving
				adminUser.setPassword(passwordEncoder.encode("password"));
				userRepository.save(adminUser);
				System.out.println(">>> Created default admin user with username 'admin' and password 'password'");
			}
		};
	}
}
