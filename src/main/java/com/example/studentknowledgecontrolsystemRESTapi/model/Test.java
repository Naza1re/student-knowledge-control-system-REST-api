package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "test")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_test")
    private String name_of_test;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questionList;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groups;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
