package com.resitic.clinica.infra.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> EntityNotFoundException() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> ArgumentsNotValidException(MethodArgumentNotValidException exception) {
		var errors = exception.getFieldErrors();
		return ResponseEntity.badRequest().body(errors.stream().map(ErrorArguments::new).toList());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> ArgumentsNotReadableException(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body(exception.getHttpInputMessage());
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> IllegalArgumentException(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
	
	public record ErrorArguments(String campo, String mensagem) {
		public ErrorArguments(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}
