package com.loixrang.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findALlByFirstNameContaining(String firstName);
}
