package com.example.demo.storage.services;

import com.example.demo.handler.exceptions.*;
import com.example.demo.storage.dto.ProductDTO;
import com.example.demo.storage.models.Product;
import com.example.demo.storage.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
            throw new ProductNotFoundException("Product not found.");
        }
    }
    private boolean СheckProduct(ProductDTO product){
        if (product.getPrice() <= 0) {
            throw new InvalidPriceException("INVALID FIELD: price.");
        }
        if(product.getCount() < 0){
            throw new InvalidCountException("INVALID FIELD: count.");
        }
        if (product.getName() == null) {
            throw new InvalidNameException("Product name cannot be null.");
        }
        if (product.getArticle() == null) {
            throw new InvalidArticleException("INVALID FIELD: article.");
        }
        if (product.getCategory() == null) {
            throw new InvalidCategoryException("INVALID FIELD: category.");
        }
        if (product.getDescription() == null) {
            throw new InvalidDescriptionException("INVALID FIELD: description.");
        }
        return true;
    }
    @Override
    public ResponseEntity<Product> create(ProductDTO productDTO) {
        Product product = Product.fromDTO(productDTO);
        if(!СheckProduct(productDTO)){
            ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(productRepository.save(product));
    }

    @Override
    public ResponseEntity<Product> update(ProductDTO productDTO, UUID id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            if(!СheckProduct(productDTO)){
                ResponseEntity.badRequest();
            }
            Product product = Product.fromDTO(productDTO);
            product.setId(id);
            product.setDate_create(existingProduct.get().getDate_create());
            Product savedProduct = productRepository.save(product);
            return ResponseEntity.ok(savedProduct);
        } else {
            throw new ProductNotFoundException("ProductNotFound");
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
