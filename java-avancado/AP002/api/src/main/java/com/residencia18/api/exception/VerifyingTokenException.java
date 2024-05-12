package com.residencia18.api.exception;

public class VerifyingTokenException extends RuntimeException {
    public VerifyingTokenException(String message) {
        super("Error verifying tokenJWT:" + message);
    }
}
