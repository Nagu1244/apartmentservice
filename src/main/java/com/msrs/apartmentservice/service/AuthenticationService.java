package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.dtos.AuthenticationRequest;
import com.msrs.apartmentservice.dtos.RegistrationRequest;
import com.msrs.apartmentservice.dtos.AuthenticationResponse;

public interface AuthenticationService {
    public AuthenticationResponse saveUserRequest(RegistrationRequest request) throws Exception;

    String authenticateUser(AuthenticationRequest authenticationRequest) throws Exception;
}
