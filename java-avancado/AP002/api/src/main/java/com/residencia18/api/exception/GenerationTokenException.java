package com.residencia18.api.exception;

public class GenerationTokenException extends RuntimeException {
    public GenerationTokenException(String message) {
        super("Error generating tokenJWT: " + message);
    }
}
