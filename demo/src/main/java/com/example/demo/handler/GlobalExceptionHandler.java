package com.example.demo.handler;

import com.example.demo.handler.exceptions.*;
import com.example.demo.storage.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<MessageDTO> userNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(404).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<MessageDTO> handleInvalidPriceException(InvalidPriceException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidCountException.class)
    public ResponseEntity<MessageDTO> handleInvalidCountException(InvalidCountException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<MessageDTO> handleInvalidNameException(InvalidNameException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<MessageDTO> handleCategoryException(InvalidCategoryException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidDescriptionException.class)
    public ResponseEntity<MessageDTO> handleDescriptionException(InvalidDescriptionException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InvalidArticleException.class)
    public ResponseEntity<MessageDTO> handleArticleException(InvalidArticleException ex) {
        return ResponseEntity.status(400).body(new MessageDTO(ex.getMessage()));
    }

}
