package com.example.shayan.api;

import com.example.shayan.entity.Student;
import com.example.shayan.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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

    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student post(@RequestBody Student student) {
        return service.create(student);
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student postOne(Student student) {
        return service.create(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        service.delete(id);
    }
}
