package com.codelabs.springbootapplication.service;

import com.codelabs.springbootapplication.exception.StudentException;
import com.codelabs.springbootapplication.model.Student;
import com.codelabs.springbootapplication.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id)
    {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()){
            return student.get();
        }
        else
        {
            throw new StudentException("Student not found");
        }
    }

    @Override
    public List<Student> fetchAllStudents()
    {
        return (List<Student>) studentRepository.findAll();
    }


}
