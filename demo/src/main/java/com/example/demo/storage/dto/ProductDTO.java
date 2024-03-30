package com.example.demo.storage.dto;

import com.example.demo.storage.models.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    @NotNull
    private String name;
    @NotNull
    private String article;
    @NotNull
    private String description;
    @NotNull
    private Category category;
    @NotNull
    private long count;
    @NotNull
    private double price;
}
