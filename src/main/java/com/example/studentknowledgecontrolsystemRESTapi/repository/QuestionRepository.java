package com.example.studentknowledgecontrolsystemRESTapi.repository;

import com.example.studentknowledgecontrolsystemRESTapi.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
}
