package com.example.demo.storage.services;

import com.example.demo.storage.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IProductServices {
    ResponseEntity<Product> read(UUID id);
    Product create(Product product);
    ResponseEntity<Product> update(Product product, UUID id);
    ResponseEntity<Product> delete(UUID id);
}
