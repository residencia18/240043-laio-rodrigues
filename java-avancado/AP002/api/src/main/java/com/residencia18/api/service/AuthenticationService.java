package com.residencia18.api.service;

import com.residencia18.api.dto.RegisterResponse;
import com.residencia18.api.exception.EmailAlreadyRegisteredException;
import com.residencia18.api.exception.UsernameAlreadyRegisteredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.residencia18.api.dto.LoginRequest;
import com.residencia18.api.dto.LoginResponse;
import com.residencia18.api.dto.RegisterRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.mapper.UserMapper;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.security.JwtProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    public RegisterResponse register(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.email()) != null)
            throw new EmailAlreadyRegisteredException();
        if (userRepository.findByUsername(registerRequest.username()) != null)
            throw new UsernameAlreadyRegisteredException();
        User user = userMapper.fromRegisterRequest(registerRequest);// Usando o UserMapper para criar o objeto User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new RegisterResponse("User registered successfully");
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),
                loginRequest.password()));
        String token = jwtProvider.generateToken(authenticate);
        return new LoginResponse(token);
    }
}
