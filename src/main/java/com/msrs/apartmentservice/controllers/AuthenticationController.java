package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.dtos.AuthenticationRequest;
import com.msrs.apartmentservice.dtos.RegistrationRequest;
import com.msrs.apartmentservice.dtos.AuthenticationResponse;
import com.msrs.apartmentservice.service.AuthenticationService;
import com.msrs.apartmentservice.utils.CommonConstants;
import com.msrs.apartmentservice.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommonConstants.USER)
public class AuthenticationController {

    @Autowired
    public AuthenticationService authenticationService;

    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUserRequest(@RequestBody RegistrationRequest request) throws Exception {
        if (request != null) {
            authenticationService.saveUserRequest(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String jwtToken = authenticationService.authenticateUser(authenticationRequest);
        return ResponseEntity.ok(jwtToken);
    }
}
