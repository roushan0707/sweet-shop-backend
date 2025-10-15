package com.palhotel.sweet_shop_backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Data JPA automatically creates methods like findAll(), findById(), save(), etc.
    // We don't need to write any code here!
}