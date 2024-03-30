package com.example.demo.storage.services;

import com.example.demo.storage.dto.ProductDTO;
import com.example.demo.storage.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IProductServices {
    ResponseEntity<Product> read(UUID id);
    ResponseEntity<Product> create(ProductDTO product);
    ResponseEntity<Product> update(ProductDTO product, UUID id);
    ResponseEntity<Product> delete(UUID id);
}
