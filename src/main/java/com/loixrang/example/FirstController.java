package com.loixrang.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findOneStudent(@PathVariable("student-id") String id) {
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(@PathVariable("student-name") String name) {
        return repository.findALlByFirstNameContaining(name);
    }

    @DeleteMapping("/students/delete/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentsById(@PathVariable("student-id") String id) {
        repository.deleteById(id);
    }
}
