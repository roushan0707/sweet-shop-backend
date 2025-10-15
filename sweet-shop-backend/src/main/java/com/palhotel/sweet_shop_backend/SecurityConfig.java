package com.palhotel.sweet_shop_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marks this as a configuration class
@EnableWebSecurity // Enables Spring's web security support
public class SecurityConfig {

    @Bean // Creates a PasswordEncoder bean that can be used anywhere in the app
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // This bean defines all our security rules
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection for our stateless REST API
                .csrf(csrf -> csrf.disable())
                // Define which requests to authorize
                .authorizeHttpRequests(auth -> auth
                        // Allow anyone to access the login endpoint and all product endpoints
                        .requestMatchers("/api/auth/**", "/api/products/**", "/api/orders/**").permitAll()
                        // Require authentication for any other request
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}

