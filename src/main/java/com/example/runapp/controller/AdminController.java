package com.example.runapp.controller;


import com.example.runapp.dto.ProductDto;
import com.example.runapp.model.Products;
import com.example.runapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/post")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto signUp){
        adminService.createProduct(signUp);
        return new ResponseEntity<>(signUp, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public void getProduct(@PathVariable Long id){
        adminService.getProductById(id);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        adminService.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        adminService.updateProduct(productDto, id);
        return new ResponseEntity<>(productDto,HttpStatus.CREATED);
    }
}
