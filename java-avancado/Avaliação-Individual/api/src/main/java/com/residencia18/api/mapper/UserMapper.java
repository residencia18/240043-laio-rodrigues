package com.residencia18.api.mapper;

import org.springframework.stereotype.Service;

import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.entity.User;

@Service
public class UserMapper {

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        return User.builder()
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(registerRequest.password())
                .role("ROLE_USER")
                .build();
    }
}
