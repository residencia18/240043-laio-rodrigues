package com.residencia18.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.residencia18.api.dto.RecoveryRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.messages.EmailMessages;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.service.EmailService;
import com.residencia18.api.service.TokenService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Random.class)
@DisplayName("Password Recovery Controller Test")
class PasswordRecoveryControllerTest {

    @Mock
    private EmailService emailService;

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PasswordRecoveryController passwordRecoveryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Password Recovery - Successful")
    void passwordRecoveryTest1() throws MessagingException {
        // GIVEN
        RecoveryRequest recoveryRequest = new RecoveryRequest("email@example.com");
        User user = new User(1L, "email@example.com", "newUser", "Testing@123", "ROLE_USER");
        String token = "validToken";

        when(userRepository.findByEmail(recoveryRequest.email())).thenReturn(user);
        when(tokenService.generateTokenRecovery(user)).thenReturn(token);

        // WHEN
        ResponseEntity<?> responseEntity = passwordRecoveryController.passwordRecovery(recoveryRequest);

        // THEN
        verify(userRepository, times(1)).findByEmail(recoveryRequest.email());
        verify(tokenService, times(1)).generateTokenRecovery(user);
        verify(emailService, times(1)).sendEmail(eq(recoveryRequest.email()), eq(EmailMessages.RECOVERY_TITLE), anyString());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Email sent successfully!", responseEntity.getBody());
    }

    @Test
    @DisplayName("Password Recovery - User Not Found")
    void passwordRecoveryTest2() throws MessagingException {
        // GIVEN
        RecoveryRequest recoveryRequest = new RecoveryRequest("nonexistentemail@example.com");

        when(userRepository.findByEmail(recoveryRequest.email())).thenReturn(null);

        // WHEN
        ResponseEntity<?> responseEntity = passwordRecoveryController.passwordRecovery(recoveryRequest);

        // THEN
        verify(userRepository, times(1)).findByEmail(recoveryRequest.email());
        verify(tokenService, never()).generateTokenRecovery(any());
        verify(emailService, never()).sendEmail(any(), any(), any());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("User not found!", responseEntity.getBody());
    }
}
