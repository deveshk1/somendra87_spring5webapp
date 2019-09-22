package com.codelabs.springbootapplication.controller;

import com.codelabs.springbootapplication.model.Student;
import com.codelabs.springbootapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/students")
public class StudentController
{
    @Autowired
    StudentService service;

    @PostMapping(value = "/student")
    public Student addStudent(@RequestBody Student student)
    {
        return service.addStudent(student);
    }

    @GetMapping(value = "/student")
    public ResponseEntity<Student> fetchStudentById(@RequestParam Long id)
    {
        Student student = service.findStudentById(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(student);
        }
    }

    @GetMapping(value = "/allstudents")
    public ResponseEntity<Student> fetchAllStudents(){
        ResponseEntity responseEntity;
        List<Student> studentList = service.fetchAllStudents();
        if (Objects.nonNull(studentList))
        {
            responseEntity = ResponseEntity.ok().body(studentList);
        }
        else
        {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
}
