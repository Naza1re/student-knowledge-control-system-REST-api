package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "answer")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_true")
    private boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
