package com.residencia18.api.exception;

import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<?> ErrorMessaging(MessagingException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ResponseEntity<?> ErrorInvalidToken(InvalidBearerTokenException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> ErrorEntityNotFound(EntityNotFoundException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(GenerationTokenException.class)
    public ResponseEntity<?> ErrorGenerationToken(GenerationTokenException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> ErrorUsernameNotFound(UsernameNotFoundException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<?> ErrorEmailAlreadyRegistered(EmailAlreadyRegisteredException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UsernameAlreadyRegisteredException.class)
    public ResponseEntity<?> ErrorUsernameAlreadyRegistered(UsernameAlreadyRegisteredException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> ErrorLoginFailed(BadCredentialsException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> ErrorAccessDenied(AccessDeniedException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ErrorArgumentsNotValid(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorArguments::new).toList());
    }

    public record ErrorArguments(String campo, String mensagem) {
        public ErrorArguments(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
