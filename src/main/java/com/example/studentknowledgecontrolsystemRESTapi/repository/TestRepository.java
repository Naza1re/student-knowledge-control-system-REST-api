package com.example.studentknowledgecontrolsystemRESTapi.repository;

import com.example.studentknowledgecontrolsystemRESTapi.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Long> {
}
