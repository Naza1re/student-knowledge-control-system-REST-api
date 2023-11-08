package com.example.studentknowledgecontrolsystemRESTapi.repository;

import com.example.studentknowledgecontrolsystemRESTapi.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
}
