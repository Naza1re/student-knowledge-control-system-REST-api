package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "question")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_question")
    private String name_of_question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answerList;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
