package com.loixrang.example.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/students")
    public StudentResponseDto post(@Valid @RequestBody StudentDto dto) {
        return studentService.createStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findOneStudent(@PathVariable("student-id") String id) {
        return studentService.findOneStudent(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name") String name) {
        return studentService.findStudentsByName(name);
    }

    @DeleteMapping("/students/delete/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentsById(@PathVariable("student-id") String id) {
        studentService.deleteStudentsById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
