package com.residencia18.api.service;

import com.residencia18.api.dto.ChangePasswordRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder encoder;

    public void resetPassword(ChangePasswordRequest request) {
        if(!tokenService.isValidToken(request.token()))
            throw new InvalidBearerTokenException("Invalid or expired token!");

        Long userId = tokenService.getId(request.token());

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        user.setPassword(encoder.encode(request.newPassword()));

        userRepository.saveAndFlush(user);
        tokenService.invalidateToken(request.token());
    }
}
