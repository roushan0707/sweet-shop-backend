package com.palhotel.sweet_shop_backend;

import jakarta.persistence.*; // Import necessary annotations

@Entity // Tells Spring this class is a table in the database
@Table(name = "products") // Specifies the table name
public class Product {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id;

    private String name;
    private double price;

    // --- Constructors, Getters and Setters (needed for JPA) ---
    public Product() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
