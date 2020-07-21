package com.example.shayan.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "studentSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSeq")
    private Long id;
    private String firstName;
    private String lastName;
    private Integer number;
}
