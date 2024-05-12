package com.residencia18.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Username is required!")
        @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters!")
        String username,
        @NotBlank(message = "Password is required!")
        @Size(min = 8, message = "Password must be at least 8 characters!")
        @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter!")
        @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter!")
        @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit!")
        @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character!")
        @Pattern(regexp = "^\\S*$", message = "Password must not contain whitespace!")
        String password,
        @NotBlank(message = "Email is required!")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email!")
        String email
) { }
