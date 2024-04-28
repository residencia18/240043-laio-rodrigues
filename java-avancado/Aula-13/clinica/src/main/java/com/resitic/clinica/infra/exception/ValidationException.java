package com.resitic.clinica.infra.exception;

public class ValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
        super("Erro de validação: " + message);
    }
}
