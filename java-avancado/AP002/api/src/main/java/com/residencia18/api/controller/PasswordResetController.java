package com.residencia18.api.controller;

import com.residencia18.api.dto.ChangePasswordRequest;
import com.residencia18.api.service.PasswordResetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PasswordResetController {
    @Autowired
    private PasswordResetService service;

    @PostMapping("/password-reset")
    public ResponseEntity<?> passwordReset(@RequestBody @Valid ChangePasswordRequest request) {
        service.resetPassword(request);
        return ResponseEntity.ok().body("Password reset successfully!");
    }
}
