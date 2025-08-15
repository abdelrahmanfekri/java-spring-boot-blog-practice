package com.blog.example.blog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.example.blog.domain.dtos.LoginRequest;
import com.blog.example.blog.domain.dtos.LoginResponse;
import com.blog.example.blog.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        String token = authenticationService.generateToken(userDetails);
        return ResponseEntity.ok(
            LoginResponse.builder()
                .token(token)
                .expiresIn(1000 * 60 * 60 * 24)
                .build()
        );
    }
}
