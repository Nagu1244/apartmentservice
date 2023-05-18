package com.msrs.apartmentservice.exceptions;

public class FlatNumberNotFoundException extends RuntimeException{
    public FlatNumberNotFoundException(String message) {
        super(message);
    }
}
