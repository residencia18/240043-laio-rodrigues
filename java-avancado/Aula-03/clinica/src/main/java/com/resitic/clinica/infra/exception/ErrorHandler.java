package com.resitic.clinica.infra.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> ErrorEntityNotFound() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> ErrorArgumentsNotValid(MethodArgumentNotValidException exception) {
		var errors = exception.getFieldErrors();
		return ResponseEntity.badRequest().body(errors.stream().map(ErrorArguments::new).toList());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> ErrorArgumentsNotReadable(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body(exception.getHttpInputMessage());
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> ErrorIllegalArgument(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
	
	@ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> ErrorBadCredentials() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> ErrorAuthentication() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> ErrorAcessoNegado() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Error500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
    }

	public record ErrorArguments(String campo, String mensagem) {
		public ErrorArguments(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}
