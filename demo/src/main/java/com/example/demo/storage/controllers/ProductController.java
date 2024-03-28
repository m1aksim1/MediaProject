package com.example.demo.storage.controllers;

import com.example.demo.storage.models.Product;
import com.example.demo.storage.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping
    public ResponseEntity create(){
        return null;
    }
    @GetMapping("/read/{id}")
    public ResponseEntity read(){
        return null;
    }
    @GetMapping("/update/{id}")
    public ResponseEntity update(){
        return null;
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity delete(){
        return null;
    }
}
