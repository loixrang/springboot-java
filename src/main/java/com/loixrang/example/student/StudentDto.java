package com.loixrang.example.student;

import java.util.UUID;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        UUID schoolId
) {
}
