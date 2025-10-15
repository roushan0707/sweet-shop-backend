package com.palhotel.sweet_shop_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Spring will automatically provide an instance of our repository
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        // This now fetches all products directly from the PostgreSQL database!
        return productRepository.findAll();
    }

    @PostMapping // This maps the method to a POST request
    public Product createProduct(@RequestBody Product newProduct) {
        // We use the repository's save() method to add the new product to the database
        return productRepository.save(newProduct);
    }


    @PutMapping("/{id}") // Handles PUT requests to /api/products/1, /api/products/2, etc.
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        // Find the existing product by its ID
        return productRepository.findById(id)
                .map(existingProduct -> {
                    // Update the name and price with the new data
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    // Save the updated product back to the database
                    return productRepository.save(existingProduct);
                })
                // If no product is found with that ID, you could return an error,
                // but for now, we'll simply return null.
                .orElse(null);
    }

    @DeleteMapping("/{id}") // Handles DELETE requests to /api/products/1, etc.
    public void deleteProduct(@PathVariable Long id) {
        // We use the repository's deleteById() method to remove the product
        productRepository.deleteById(id);
    }
    @GetMapping("/{id}") // Handles GET requests to /api/products/1, /api/products/2, etc.
    public Optional<Product> getProductById(@PathVariable Long id) {
        // This uses the repository's findById() method to get a single product
        return productRepository.findById(id);
    }
}
