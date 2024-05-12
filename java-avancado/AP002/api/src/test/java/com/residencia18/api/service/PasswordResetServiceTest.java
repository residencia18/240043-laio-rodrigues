package com.residencia18.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.residencia18.api.dto.ChangePasswordRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.service.PasswordResetService;
import com.residencia18.api.service.TokenService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;

@SpringBootTest
@DisplayName("Password Reset Service Test")
class PasswordResetServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private PasswordResetService passwordResetService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Reset Password - Successful")
    void resetPasswordTest1() {
        // GIVEN
        ChangePasswordRequest request = new ChangePasswordRequest("validToken", "newPassword");
        User user = new User(1L, "email@example.com", "username", "oldPassword", "ROLE_USER");

        when(tokenService.isValidToken(request.token())).thenReturn(true);
        when(tokenService.getId(request.token())).thenReturn(user.getId());
        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        when(passwordEncoder.encode(request.newPassword())).thenReturn("encodedNewPassword");

        // WHEN
        passwordResetService.resetPassword(request);

        // THEN
        verify(tokenService, times(1)).isValidToken(request.token());
        verify(tokenService, times(1)).getId(request.token());
        verify(userRepository, times(1)).findById(user.getId());
        verify(passwordEncoder, times(1)).encode(request.newPassword());
        verify(userRepository, times(1)).saveAndFlush(user);
        verify(tokenService, times(1)).invalidateToken(request.token());
        assertEquals("encodedNewPassword", user.getPassword());
    }

    @Test
    @DisplayName("Reset Password - Invalid Token")
    void resetPasswordTest2() {
        // GIVEN
        ChangePasswordRequest request = new ChangePasswordRequest("invalidToken", "newPassword");

        when(tokenService.isValidToken(request.token())).thenReturn(false);

        // WHEN/THEN
        assertThrows(InvalidBearerTokenException.class, () -> passwordResetService.resetPassword(request));

        verify(tokenService, times(1)).isValidToken(request.token());
        verify(tokenService, never()).getId(any());
        verify(userRepository, never()).findById(any());
        verify(passwordEncoder, never()).encode(any());
        verify(userRepository, never()).saveAndFlush(any());
        verify(tokenService, never()).invalidateToken(any());
    }

    @Test
    @DisplayName("Reset Password - User Not Found")
    void resetPasswordTest3() {
        // GIVEN
        ChangePasswordRequest request = new ChangePasswordRequest("validToken", "newPassword");

        when(tokenService.isValidToken(request.token())).thenReturn(true);
        when(tokenService.getId(request.token())).thenReturn(1L);
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // WHEN/THEN
        assertThrows(EntityNotFoundException.class, () -> passwordResetService.resetPassword(request));

        verify(tokenService, times(1)).isValidToken(request.token());
        verify(tokenService, times(1)).getId(request.token());
        verify(userRepository, times(1)).findById(1L);
        verify(passwordEncoder, never()).encode(any());
        verify(userRepository, never()).saveAndFlush(any());
        verify(tokenService, never()).invalidateToken(any());
    }
}