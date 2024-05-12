package com.residencia18.api.mapper;

import org.springframework.stereotype.Service;

import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.entity.User;

@Service
public class UserMapper {

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        return new User(
                null,
                registerRequest.email(),
                registerRequest.username(),
                registerRequest.password(),
                "ROLE_USER"
        );
    }
}
