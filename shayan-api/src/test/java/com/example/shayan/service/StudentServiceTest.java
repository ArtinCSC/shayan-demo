package com.example.shayan.service;

import com.example.shayan.ShayanApplication;
import com.example.shayan.entity.Student;
import com.example.shayan.repository.StudentRepository;
import javassist.NotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {ShayanApplication.class})
@TestPropertySource(locations = {"classpath:application.properties"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository repo;

    @Test
    public void givenStudentWhenGetThenGet() throws NotFoundException {
        Student s = createStudents();
        s = repo.save(s);

        Student getStudent = studentService.get(s.getId());
        assertNotNull(getStudent);
    }

    private Student createStudents() {
        Student student = new Student();
        student.setFirstName("Shayan");
        student.setLastName("lastname");
        student.setNumber(123456);
        return student;
    }
}
