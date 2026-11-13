package com.loixrang.example.student;

import com.loixrang.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstname());
        student.setLastName(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
