package com.example.studentknowledgecontrolsystemRESTapi.controller;

import com.example.studentknowledgecontrolsystemRESTapi.exception.TeacherNotFounException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Subject;
import com.example.studentknowledgecontrolsystemRESTapi.model.Teacher;
import com.example.studentknowledgecontrolsystemRESTapi.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all-teachers")
    public ResponseEntity<List<Teacher>> getAllTeachersList(){
        return teacherService.getAllTeachers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) throws TeacherNotFounException {
        return teacherService.getTeacherById(id);
    }
    @GetMapping("/{id}/all-subjects")
    public ResponseEntity<List<Subject>> getAllSubjectListOfTeacher(@PathVariable Long id) throws TeacherNotFounException {
        return teacherService.getAllSubjectByTeacherId(id);
    }
    @PostMapping("/create-teacher")
    public HttpStatus createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }


}
