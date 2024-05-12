package com.residencia18.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank(message = "The token is required!")
        String token,
        @NotBlank(message = "The new password is required!")
        @Size(min = 8, message = "Password must be at least 8 characters!")
        @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter!")
        @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter!")
        @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit!")
        @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character!")
        @Pattern(regexp = "^\\S*$", message = "Password must not contain whitespace!")
        String newPassword
) { }
