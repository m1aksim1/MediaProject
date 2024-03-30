package com.example.demo.storage.models;

import com.example.demo.storage.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String article;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private long count;
    private double price;
    private LocalDateTime date_last_change;
    private LocalDateTime date_create;

    public static Product fromDTO(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .article(productDTO.getArticle())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .count(productDTO.getCount())
                .price(productDTO.getPrice())
                .build();
    }
    @PrePersist
    public void prePersist() {
        this.date_create = LocalDateTime.now();
        this.date_last_change = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.date_last_change = LocalDateTime.now();
    }
}
