package com.msrs.apartmentservice.exceptions;

public class FaltOccupiedException extends RuntimeException{
    public FaltOccupiedException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public FaltOccupiedException(String message) {
        super(message);
    }
}
