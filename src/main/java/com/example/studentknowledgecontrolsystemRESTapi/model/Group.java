package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "group_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_group")
    private String name_of_group;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> studentList;

    @OneToMany(mappedBy = "group")
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "groups")
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
