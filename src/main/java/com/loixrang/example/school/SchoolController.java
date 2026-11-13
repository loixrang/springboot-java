package com.loixrang.example.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto) {
        return schoolService.create(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolService.findAllSchool();
    }
}
