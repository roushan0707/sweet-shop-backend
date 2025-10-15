package com.palhotel.sweet_shop_backend;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Spring Data JPA will automatically provide all the necessary methods
}
