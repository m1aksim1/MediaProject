package com.example.demo.storage.controllers;

import com.example.demo.storage.dto.ProductDTO;
import com.example.demo.storage.models.Category;
import com.example.demo.storage.models.Product;
import com.example.demo.storage.repositories.ProductRepository;
import com.example.demo.storage.services.ProductServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ProductControllerTest {


    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductServices productService;
    @Mock
    private ProductRepository productRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateProduct(){
        ProductDTO product = ProductDTO.builder()
                .name("ryzen 7700x")
                .article("331")
                .description("Новый 8-ми ядерный процессор")
                .category(Category.ELECTRONICS)
                .count(50)
                .price(15000)
                .build();
        productController.create(product);
        List<Product> products = productController.getAllProducts();
    }
}