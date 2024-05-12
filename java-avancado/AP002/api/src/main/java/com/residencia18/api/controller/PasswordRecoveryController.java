package com.residencia18.api.controller;

import com.residencia18.api.dto.RecoveryRequest;
import com.residencia18.api.entity.User;
import com.residencia18.api.messages.EmailMessages;
import com.residencia18.api.repository.UserRepository;
import com.residencia18.api.service.EmailService;
import com.residencia18.api.service.TokenService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PasswordRecoveryController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/password-recovery")
    public ResponseEntity<?> passwordRecovery(@RequestBody @Valid RecoveryRequest request) throws MessagingException {

        User user = userRepository.findByEmail(request.email());
        if(user == null) return ResponseEntity.badRequest().body("User not found!");

        String token = tokenService.generateTokenRecovery(user);
        String url = "http://localhost:4200/recover-password/?token=" + token;  //Url of the form to fill in with the new password.

        emailService.sendEmail(request.email(), EmailMessages.RECOVERY_TITLE, EmailMessages.messageToRecovery(user, url));

        return ResponseEntity.ok().body("Email sent successfully!");
    }
}
