package com.example.shayan.service;

import com.example.shayan.entity.Student;
import javassist.NotFoundException;

import java.util.List;

public interface StudentService {
    Student get(Long id) throws NotFoundException;
    List<Student> getStudents();
    Student create(Student student);

    void delete(Long id) throws NotFoundException;
}
