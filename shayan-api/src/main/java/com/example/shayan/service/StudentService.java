package com.example.shayan.service;

import com.example.shayan.entity.Student;
import javassist.NotFoundException;

public interface StudentService {
    Student get(Long id) throws NotFoundException;

    Student create(Student student);

    void delete(Long id) throws NotFoundException;
}
