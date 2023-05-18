package com.msrs.apartmentservice.exceptions;

public class FlatAlareadyExistException extends RuntimeException{
    public FlatAlareadyExistException(String message){
        super(message);
    }
}
