package com.codelabs.springbootapplication.repo;

import com.codelabs.springbootapplication.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>
{
}
