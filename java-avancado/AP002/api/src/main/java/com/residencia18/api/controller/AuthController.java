package com.residencia18.api.controller;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia18.api.dto.LoginRequest;
import com.residencia18.api.dto.LoginResponse;
import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.dto.RegisterResponse;
import com.residencia18.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {
        RegisterResponse response = authenticationService.register(registerRequest);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse response = authenticationService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
