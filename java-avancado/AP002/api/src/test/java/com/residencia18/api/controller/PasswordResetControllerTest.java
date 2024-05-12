package com.residencia18.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.residencia18.api.dto.ChangePasswordRequest;
import com.residencia18.api.service.PasswordResetService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Random.class)
@DisplayName("Password Reset Controller Test")
class PasswordResetControllerTest {

    @Mock
    private PasswordResetService passwordResetService;

    @InjectMocks
    private PasswordResetController passwordResetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Password Reset - Successful")
    void passwordResetTest() {
        // Given
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest("validToken", "newPassword");

        // When
        ResponseEntity<?> responseEntity = passwordResetController.passwordReset(changePasswordRequest);

        // Then
        verify(passwordResetService, times(1)).resetPassword(changePasswordRequest);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Password reset successfully!", responseEntity.getBody());
    }
}
