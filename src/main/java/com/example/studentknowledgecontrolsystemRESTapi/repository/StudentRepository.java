package com.example.studentknowledgecontrolsystemRESTapi.repository;

import com.example.studentknowledgecontrolsystemRESTapi.model.Group;
import com.example.studentknowledgecontrolsystemRESTapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
