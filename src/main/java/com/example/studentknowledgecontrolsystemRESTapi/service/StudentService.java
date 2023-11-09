package com.example.studentknowledgecontrolsystemRESTapi.service;

import com.example.studentknowledgecontrolsystemRESTapi.exception.GroupNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.exception.StudentNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Group;
import com.example.studentknowledgecontrolsystemRESTapi.model.Student;
import com.example.studentknowledgecontrolsystemRESTapi.repository.GroupRepository;
import com.example.studentknowledgecontrolsystemRESTapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public ResponseEntity<List<Student>> getStudentsOfGroup(String groupName) throws GroupNotFoundException {
        Optional<Group> opt_group = groupRepository.findByName(groupName);
        if(opt_group.isPresent()){

            List<Student> students = opt_group.get().getStudentList();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        else throw new GroupNotFoundException("group with name '"+ groupName+ "' not found");
    }

    public ResponseEntity<Student> getStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> opt_student = studentRepository.findById(id);
        if(opt_student.isPresent()){
            return new  ResponseEntity<>(opt_student.get(),HttpStatus.OK);
        }
        else throw new StudentNotFoundException("student with id '"+ id+ "' not found");


    }

    public HttpStatus addStudentToGroup(Student student, String groupName) throws GroupNotFoundException {
        Optional<Group> opt_group = groupRepository.findByName(groupName);
        if(opt_group.isPresent()) {
            student.setGroup(opt_group.get());
            studentRepository.save(student);
            return HttpStatus.OK;
        }
        else throw new GroupNotFoundException("group with name '"+ groupName+ "' not found");
    }

    public HttpStatus deleteStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> opt_student = studentRepository.findById(id);
        if(opt_student.isPresent()){
            studentRepository.delete(opt_student.get());
            return HttpStatus.OK;
        }
        else throw new StudentNotFoundException("student with id '"+ id+ "' not found");

    }
}
