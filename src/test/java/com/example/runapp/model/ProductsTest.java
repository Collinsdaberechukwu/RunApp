package com.example.runapp.model;

import com.example.runapp.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    private ProductRepository productRepository;
    @Test
    public void createNewProductTest(){
        Products products = Products.builder()
                .productAmount("$10,000")
                .productName("Iphone 25")
                .description("289 Apple product")
                .build();
        productRepository.save(products);

//        Assertions.assertThat(products.getId()).isGreaterThan(0);
    }

}