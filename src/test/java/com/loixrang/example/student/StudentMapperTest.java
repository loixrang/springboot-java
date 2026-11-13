package com.loixrang.example.student;

import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("john", "doe", "john@mail.com", UUID.fromString("16111aa2-f106-4923-934c-f88437089646"));

        Student student = mapper.toStudent(dto);
        assertEquals(dto.firstname(), student.getFirstName());
        assertEquals(dto.lastname(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.schoolId(), student.getSchool().getId());
        assertNotNull(student.getSchool());
    }

    @Test
    public void shouldMapStudentResponseDtoToStudent() {
        Student student = new Student("john", "doe", "john@mail.com", 19);

        StudentResponseDto response = mapper.toStudentResponseDto(student);
        assertEquals(response.firstname(), student.getFirstName());
        assertEquals(response.lastname(), student.getLastName());
        assertEquals(student.getEmail(), response.email());
    }
}