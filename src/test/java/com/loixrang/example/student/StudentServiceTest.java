package com.loixrang.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.UUID;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    //dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullySaveStudent() {
        StudentDto dto = new StudentDto("john", "doe", "john@mail.com", UUID.fromString("16111aa2-f106-4923-934c-f88437089646"));
        Student student = new Student("john", "doe", "john@mail.com", 19);

        //Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponseDto(student))
                .thenReturn(new StudentResponseDto(
                        "john", "doe", "john@mail.com"
                ));

        //when
        StudentResponseDto responseDto = studentService.createStudent(dto);

        //then
        assertEquals(dto.firstname(), responseDto.firstname());
        assertEquals(dto.lastname(), responseDto.lastname());
        assertEquals(dto.email(), responseDto.email());
    }
}