package com.residencia18.api.service;

import com.residencia18.api.dto.LoginRequest;
import com.residencia18.api.dto.LoginResponse;
import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.exception.EmailAlreadyRegisteredException;
import com.residencia18.api.exception.UsernameAlreadyRegisteredException;
import com.residencia18.api.mapper.UserMapper;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.security.JwtProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Authentication Service Test")
class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtProvider jwtProvider;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    @DisplayName("Test Register - Successful Registration")
    void registerTest1() {
        //GIVEN
        RegisterRequest registerRequest = new RegisterRequest("newUser", "Testing@123", "newuser@example.com");
        User user = new User(1L, registerRequest.email(), registerRequest.username(), registerRequest.password(), "ROLE_USER");

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userMapper.fromRegisterRequest(any())).thenReturn(user);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        // WHEN
        authenticationService.register(registerRequest);

        // THEN
        verify(userRepository, times(1)).findByEmail(anyString());
        verify(userRepository, times(1)).findByUsername(anyString());
        verify(userMapper, times(1)).fromRegisterRequest(registerRequest);
        verify(passwordEncoder, times(1)).encode(registerRequest.password());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    @DisplayName("Test Register - Email Already Registered")
    void registerTest2() {
        // GIVEN
        RegisterRequest registerRequest = new RegisterRequest("NewUser", "Testing@123", "existingemail@example.com");

        when(userRepository.findByEmail(anyString())).thenReturn(new User());

        // WHEN/THEN
        assertThrows(EmailAlreadyRegisteredException.class, () -> authenticationService.register(registerRequest));

        verify(userRepository, times(1)).findByEmail(anyString());
        verify(userRepository, never()).findByUsername(anyString());
        verify(userMapper, never()).fromRegisterRequest(registerRequest);
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test Register - Username Already Registered")
    void registerTest3() {
        // GIVEN
        RegisterRequest registerRequest = new RegisterRequest("existinguser", "Testing@123", "newemail@example.com");

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.findByUsername(anyString())).thenReturn(new User());

        // WHEN/THEN
        assertThrows(UsernameAlreadyRegisteredException.class, () -> authenticationService.register(registerRequest));

        verify(userRepository, times(1)).findByEmail(anyString());
        verify(userRepository, times(1)).findByUsername(anyString());
        verify(userMapper, never()).fromRegisterRequest(registerRequest);
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test Login - Successful")
    void loginTest() {
        // GIVEN
        LoginRequest loginRequest = new LoginRequest("username", "password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(authenticationToken)).thenReturn(authentication);
        when(jwtProvider.generateToken(authentication)).thenReturn("mockedToken");

        // WHEN
        LoginResponse response = authenticationService.login(loginRequest);

        // THEN
        assertEquals("mockedToken", response.token());

        verify(authenticationManager, times(1)).authenticate(authenticationToken);
        verify(jwtProvider, times(1)).generateToken(authentication);
    }
}