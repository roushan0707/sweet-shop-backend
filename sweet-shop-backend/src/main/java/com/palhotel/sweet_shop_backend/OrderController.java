package com.palhotel.sweet_shop_backend;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import java.util.List;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order newOrder) {
        // Set the current date and time for the order before saving
        newOrder.setOrderDate(LocalDateTime.now());
        // Save the new order to the database and return it
        return orderRepository.save(newOrder);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        // This finds all orders and sorts them by date, showing the newest ones first.
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderDate"));
    }
}
