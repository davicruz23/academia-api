package com.academy.academyapi.controller;

import com.academy.academyapi.domain.Student;
import com.academy.academyapi.domain.dto.student.CreateStudentDTO;
import com.academy.academyapi.domain.dto.student.StudentDTO;
import com.academy.academyapi.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById (@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> findAll (){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody CreateStudentDTO dto) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.create(dto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}