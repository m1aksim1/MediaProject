package com.example.demo.storage.services;

import com.example.demo.storage.dto.ProductDTO;
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
    public ResponseEntity<Product>  create(ProductDTO productDTO) {
        Product product = Product.fromDTO(productDTO);
        return ResponseEntity.ok(productRepository.save(product));
    }

    @Override
    public ResponseEntity<Product> update(ProductDTO productDTO, UUID id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product product = Product.fromDTO(productDTO);
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
