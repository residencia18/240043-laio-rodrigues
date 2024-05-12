package com.residencia18.api.entity;

import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
@DisplayName("User entity test")
class UserTest {

    @Test
    @DisplayName("Create one user from entity")
    public void createUserTest1() {
        //  GIVEN
        User user = new User(null, "test@email.com", "userTest", "Teste@123", "ROLE_USER");
        User user2 = new User();

        // WHEN
        user2.setEmail("test@email.com");
        user2.setUsername("userTest");
        user2.setPassword("Teste@123");
        user2.setRole("ROLE_USER");

        // THEN
        assertEquals(user.getEmail(), user2.getEmail());
        assertEquals(user.getUsername(), user2.getUsername());
        assertEquals(user.getPassword(), user2.getPassword());
        assertEquals(user.getRole(), user2.getRole());
    }

    @Test
    @DisplayName("Create one user from request")
    public void createUserTest2(){
        //GIVEN
        User user = new User(null, "test@email.com", "userTest", "Teste@123", "ROLE_USER");
        RegisterRequest request = new RegisterRequest("userTest", "Teste@123", "test@email.com");
        UserMapper mapper = new UserMapper();

        //WHEN
        User user2 = mapper.fromRegisterRequest(request);

        //THEN
        assertEquals(user.getEmail(), user2.getEmail());
        assertEquals(user.getUsername(), user2.getUsername());
        assertEquals(user.getPassword(), user2.getPassword());
        assertEquals(user.getRole(), user2.getRole());
    }
}