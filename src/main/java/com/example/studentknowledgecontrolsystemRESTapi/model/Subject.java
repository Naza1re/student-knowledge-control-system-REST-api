package com.example.studentknowledgecontrolsystemRESTapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "subject")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_subject")
    private String name_of_subject;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
