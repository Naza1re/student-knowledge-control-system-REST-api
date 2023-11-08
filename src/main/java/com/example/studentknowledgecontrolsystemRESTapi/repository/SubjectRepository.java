package com.example.studentknowledgecontrolsystemRESTapi.repository;

import com.example.studentknowledgecontrolsystemRESTapi.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Long> {
}
