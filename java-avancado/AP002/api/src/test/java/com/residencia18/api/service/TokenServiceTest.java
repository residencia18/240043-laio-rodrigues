package com.residencia18.api.service;

import com.residencia18.api.entity.User;
import com.residencia18.api.exception.VerifyingTokenException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Random.class)
@DisplayName("Token Service Test")
class TokenServiceTest {
    @Autowired
    private TokenService tokenService;

    @Test
    @DisplayName("Cycle of using a token")
    void cycleOfUsingAToken() {
        try{
            //GIVEN
            User user = new User(null, "test@email.com", "userTest", "Teste@123", "ROLE_USER");
            String token = tokenService.generateTokenRecovery(user);

            //WHEN
            boolean isValid = tokenService.isValidToken(token);

            //THEN
            assertTrue(isValid);

            //WHEN
            String email = tokenService.getEmail(token);
            Long id = tokenService.getId(token);

            //THEN
            assertEquals(user.getEmail(), email);
            assertEquals(user.getId(), id);

            //WHEN
            tokenService.invalidateToken(token);

            //THEN
            isValid = tokenService.isValidToken(token);
            assertFalse(isValid);

        }catch (Exception exception){
            fail("Undue Exception: " + exception.getMessage());
        }
    }

    @Test
    @DisplayName("Invalid Token")
    void invalidToken() {
        // GIVEN
        String invalidToken = "invalidToken";

        // WHEN
        boolean isValid = tokenService.isValidToken(invalidToken);

        // THEN
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Invalid Token - Get Email")
    void invalidToken_GetEmail() {
        String email = null;
        try{
            // GIVEN
            String invalidToken = "invalidToken";

            // WHEN
            email = tokenService.getEmail(invalidToken);
        }catch (VerifyingTokenException exception){
            // THEN
            assertNull(email);
        }
    }

    @Test
    @DisplayName("Invalid Token - Get ID")
    void invalidToken_GetId() {
        Long id = null;
        try {
            // GIVEN
            String invalidToken = "invalidToken";

            // WHEN
            id = tokenService.getId(invalidToken);
        }catch (VerifyingTokenException exception){
            // THEN
            assertNull(id);
        }
    }

    @Test
    @DisplayName("Already Invalidated Token")
    void alreadyInvalidatedToken() {
        // GIVEN
        User user = new User(null, "email@example.com", "username", "password", "ROLE_USER");
        String token = tokenService.generateTokenRecovery(user);
        tokenService.invalidateToken(token);

        // WHEN
        boolean isValid = tokenService.isValidToken(token);

        // THEN
        assertFalse(isValid);
    }

}