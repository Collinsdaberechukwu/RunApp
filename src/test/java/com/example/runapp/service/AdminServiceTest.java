package com.example.runapp.service;

import com.example.runapp.model.Admin;
import com.example.runapp.model.Products;
import com.example.runapp.repository.AdminRepository;
import com.example.runapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class AdminServiceTest {
     private final AdminRepository adminRepository;
     private final ProductRepository productRepository;
    @Test
    void createProduct() {
        Admin products = new Admin();
        products.setFirstName("Mac BookAir");
        products.setLastName("200,000");
        products.setUsername("Apple Product");
        products.setPassword("1234rfght");
        products.setEmail("collins@gmail.com");


        Admin saved = adminRepository.save(products);
        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isGreaterThan(0);
    }

    @Test
    void getProductById() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }
}