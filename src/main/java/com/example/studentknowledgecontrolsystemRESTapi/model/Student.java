package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "student")
@Entity
public class Student {
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "average_score")
    private double average_score;

    @Column(name = "date_of_birthday")
    private String date_of_birthday;

    @Column(name = "course")
    private int course;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    private Group group;


}
