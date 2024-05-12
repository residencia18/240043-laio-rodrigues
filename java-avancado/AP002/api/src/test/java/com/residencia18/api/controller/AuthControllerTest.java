package com.residencia18.api.controller;

import com.residencia18.api.dto.LoginRequest;
import com.residencia18.api.dto.LoginResponse;
import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.dto.RegisterResponse;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.service.AuthenticationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AuthControllerTest {
    @Autowired
    private MockMvc mvc;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthController authController;

    @Test
    @DisplayName("Registration with invalid data")
    void registerTest1() throws Exception{
        var response = mvc
                .perform(post("/api/auth/register"))
                .andReturn().getResponse();
        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Registration with valid data")
    void registerTest2() {
        // GIVEN
        RegisterRequest registerRequest = new RegisterRequest("newUser", "Testing@123", "email@example.com");
        RegisterResponse registerResponse = new RegisterResponse("Registered successfully!");

        when(authenticationService.register(registerRequest)).thenReturn(registerResponse);

        // WHEN
        ResponseEntity<RegisterResponse> responseEntity = authController.register(registerRequest);

        // THEN
        verify(authenticationService, times(1)).register(registerRequest);
        assertSame(registerResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Login with invalid data")
    void loginTest1() throws Exception{
        var response = mvc
                .perform(post("/api/auth/login"))
                .andReturn().getResponse();
        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Login with valid data")
    void loginTest2() {
        // GIVEN
        LoginRequest loginRequest = new LoginRequest("newUser", "Testing@123");
        LoginResponse loginResponse = new LoginResponse("JWT Token");

        when(authenticationService.login(loginRequest)).thenReturn(loginResponse);

        // WHEN
        ResponseEntity<LoginResponse> responseEntity = authController.login(loginRequest);

        // THEN
        verify(authenticationService, times(1)).login(loginRequest);
        assertSame(loginResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}