package com.msrs.apartmentservice.exceptions;

public class ApartmentNotFoundException extends RuntimeException{
    public ApartmentNotFoundException(String message) {
        super(message);
    }
    public ApartmentNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
