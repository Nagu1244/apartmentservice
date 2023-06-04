package com.msrs.apartmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> mapErrorFields = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> mapErrorFields.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapErrorFields);
    }

    @ExceptionHandler(FaltOccupiedException.class)
    public ResponseEntity<?> handleFlatOccupiedException(FaltOccupiedException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }

    @ExceptionHandler(FlatNumberNotFoundException.class)
    public ResponseEntity<?> handleFlatOccupiedException(FlatNumberNotFoundException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
