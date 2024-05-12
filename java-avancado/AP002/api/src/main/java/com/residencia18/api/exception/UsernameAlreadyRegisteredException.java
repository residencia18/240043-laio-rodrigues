package com.residencia18.api.exception;

public class UsernameAlreadyRegisteredException extends RuntimeException {
    public UsernameAlreadyRegisteredException(){
        super("Username already registered!");
    }
}
