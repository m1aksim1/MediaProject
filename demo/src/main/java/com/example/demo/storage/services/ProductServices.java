package com.example.demo.storage.services;

import com.example.demo.storage.models.Product;
import com.example.demo.storage.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServices implements IProductServices  {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> read(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> update(Product product, UUID id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            product.setId(id);
            Product savedProduct = productRepository.save(product);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Product> delete(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
