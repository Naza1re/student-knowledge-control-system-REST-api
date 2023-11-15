package com.example.studentknowledgecontrolsystemRESTapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "teacher")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjectList;
}
