package com.resitic.clinica.infra.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> ErrorEntityNotFound() {
		log.info("Exception lançada: Entidade não encontrada!");
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> ErrorArgumentsNotValid(MethodArgumentNotValidException exception) {
		var errors = exception.getFieldErrors();
		log.info("Exception lançada: Argumentos inválidos!");
		return ResponseEntity.badRequest().body(errors.stream().map(ErrorArguments::new).toList());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> ErrorArgumentsNotReadable(HttpMessageNotReadableException exception) {
		log.info("Exception lançada: Argumento não lido corretamente!");
		return ResponseEntity.badRequest().body(exception.getHttpInputMessage());
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> ErrorIllegalArgument(SQLIntegrityConstraintViolationException exception) {
		log.info("Exception lançada: A query não encontrou um dado válido!");
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
	
	@ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> ErrorBadCredentials() {
		log.info("Exception lançada: Credenciais inválidas!");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> ErrorAuthentication() {
    	log.info("Exception lançada: Falha na autenticação!");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> ErrorAcessoNegado() {
    	log.info("Exception lançada: Acesso negado!");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Error500(Exception ex) {
    	log.info("Exception lançada: Erro interno!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> Error500(RuntimeException ex) {
        log.info("Exception lançada: Erro interno!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
    }

	public record ErrorArguments(String campo, String mensagem) {
		public ErrorArguments(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}
