package com.example.shayan.service;

import com.example.shayan.entity.Student;
import com.example.shayan.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    public Student get(Long id) throws NotFoundException {
        Student student = repo.findById(id).orElse(null);
        if (student == null) {
            throw new NotFoundException("Student not found!");
        }
        return student;
    }

    public Student create(Student student) {
        return repo.save(student);
    }

    public void delete(Long id) throws NotFoundException {
        Student student = get(id);
        repo.delete(student);
    }
}
