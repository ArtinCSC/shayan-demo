package com.example.shayan.api;

import com.example.shayan.entity.Student;
import com.example.shayan.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentResource {

    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public Student get(@PathVariable("id") Long id) throws NotFoundException {
        return service.get(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getStudents();
    }

    @PostMapping
    public Student post(@RequestBody Student student) {
        return service.create(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        service.delete(id);
    }
}
