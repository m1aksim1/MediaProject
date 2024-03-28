package com.example.demo.storage.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
@AllArgsConstructor
public class ProductController {
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
