package com.msrs.apartmentservice.service.impl;

import com.msrs.apartmentservice.configurations.security.JwtService;
import com.msrs.apartmentservice.dtos.AuthenticationRequest;
import com.msrs.apartmentservice.dtos.RegistrationRequest;
import com.msrs.apartmentservice.dtos.AuthenticationResponse;
import com.msrs.apartmentservice.model.Role;
import com.msrs.apartmentservice.model.User;
import com.msrs.apartmentservice.repository.UserRepository;
import com.msrs.apartmentservice.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse saveUserRequest(RegistrationRequest request) throws Exception {
            User user = User.builder()
                    .userName(request.getUserName())
                    .email(request.getEmail())
                    .role(Role.USER)
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
    }

    @Override
    public String authenticateUser(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        } catch (Exception exception){
            throw new Exception("Invalid User name or password");
        }
        UserDetails userDetails = userRepository.findByEmail(authenticationRequest.getEmail());
        String jwtToken = jwtService.generateToken(userDetails);
        return jwtToken;
    }
}
