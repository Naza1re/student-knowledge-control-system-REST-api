package com.example.studentknowledgecontrolsystemRESTapi.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "answer")
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_true")
    private boolean is_true;
}
