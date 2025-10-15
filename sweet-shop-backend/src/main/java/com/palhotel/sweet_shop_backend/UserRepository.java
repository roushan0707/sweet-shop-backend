package com.palhotel.sweet_shop_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will automatically create this method for us
    // It allows us to find a user by their username
    Optional<User> findByUsername(String username);
}