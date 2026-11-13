package com.loixrang.example.student;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record StudentDto(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty")
        String lastname,
        @NotEmpty(message = "email should not be empty")
        @Email
        String email,
        @NotNull(message = "School ID is required")
        UUID schoolId
) {
}
