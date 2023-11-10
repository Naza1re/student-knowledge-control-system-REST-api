package com.example.studentknowledgecontrolsystemRESTapi.controller;

import com.example.studentknowledgecontrolsystemRESTapi.exception.GroupNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.exception.StudentNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Student;
import com.example.studentknowledgecontrolsystemRESTapi.repository.GroupRepository;
import com.example.studentknowledgecontrolsystemRESTapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/{group_name}/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> getAllStudentOfGroup(@PathVariable String group_name) throws GroupNotFoundException {
        return studentService.getStudentsOfGroup(group_name);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String group_name, @PathVariable Long id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
    @PostMapping("/add-student")
    public HttpStatus addStudent(@RequestBody Student student, @PathVariable String group_name) throws GroupNotFoundException {
        return studentService.addStudentToGroup(student,group_name);
    }
    @DeleteMapping("/{id}/delete-student")
    public HttpStatus deleteStudentById(@PathVariable String group_name, @PathVariable Long id) throws StudentNotFoundException {
        return studentService.
                deleteStudentById(id);
    }
}
