package com.example.runapp.service;

import com.example.runapp.dto.ProductDto;
import com.example.runapp.model.Products;
import com.example.runapp.repository.AdminRepository;
import com.example.runapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final ProductRepository productRepository;

    public ResponseEntity<Products> createProduct(ProductDto productDto){
        Products newProduct = new Products();
        newProduct.setProductName(productDto.getProductName());
        newProduct.setProductAmount(productDto.getProductAmount());
        newProduct.setDescription(productDto.getDescription());

        Products savedProducts = productRepository.save(newProduct);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    public void getProductById(Long id){
        productRepository.findAllById(Collections.singleton(id));
//        return getProductById(id);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ResponseEntity<Products> updateProduct(ProductDto productDto, Long id){
        Products updatedProduct= productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product out of stock upload new product"));
        updatedProduct.setDescription(productDto.getDescription());
        updatedProduct.setProductAmount(productDto.getProductAmount());
        updatedProduct.setProductName(productDto.getProductName());

        Products savedProduct = productRepository.save(updatedProduct);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);

    }
}
