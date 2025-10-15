package com.palhotel.sweet_shop_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // --- DEBUGGING LINES ---
        System.out.println(">>> Attempting login for user: " + loginRequest.username());
        // --- END DEBUGGING ---

        Optional<User> userOptional = userRepository.findByUsername(loginRequest.username());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // --- DEBUGGING LINES ---
            System.out.println(">>> User found in database: " + user.getUsername());
            boolean passwordMatches = passwordEncoder.matches(loginRequest.password(), user.getPassword());
            System.out.println(">>> Does password match? " + passwordMatches);
            // --- END DEBUGGING ---

            if (passwordMatches) {
                return ResponseEntity.ok(Map.of("message", "Login Successful"));
            }
        } else {
            // --- DEBUGGING LINES ---
            System.out.println(">>> User NOT found in database.");
            // --- END DEBUGGING ---
        }

        return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
    }
}
