package com.codelabs.springbootapplication.service;

import com.codelabs.springbootapplication.model.Student;

import java.util.List;

public interface StudentService
{
    Student addStudent(Student student);
    Student findStudentById(Long id);
    List<Student> fetchAllStudents();
}
