package com.example.demo.storage.controllers;

import com.example.demo.storage.models.Product;
import com.example.demo.storage.repositories.ProductRepository;
import com.example.demo.storage.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Product")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private final ProductServices productService;


    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping
    public ResponseEntity create(@RequestBody Product product){
        return ResponseEntity.status(201).body(productService.create(product));
    }
    @GetMapping("/read/{id}")
    public ResponseEntity read(@PathVariable UUID id){
        return ResponseEntity.ok(productRepository.getById(id));
    }
    @GetMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Product product, @PathVariable UUID id){
        return ResponseEntity.status(201).body(productService.update(product,id));
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return ResponseEntity.status(201).body(productService.delete(id));
    }
}
