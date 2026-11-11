package com.loixrang.example;

import java.util.UUID;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        UUID schoolId
) {
}
