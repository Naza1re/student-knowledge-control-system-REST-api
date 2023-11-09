package com.example.studentknowledgecontrolsystemRESTapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "student")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
