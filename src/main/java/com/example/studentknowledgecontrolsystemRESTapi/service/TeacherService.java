package com.example.studentknowledgecontrolsystemRESTapi.service;

import com.example.studentknowledgecontrolsystemRESTapi.exception.TeacherNotFounException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Subject;
import com.example.studentknowledgecontrolsystemRESTapi.model.Teacher;
import com.example.studentknowledgecontrolsystemRESTapi.repository.SubjectRepository;
import com.example.studentknowledgecontrolsystemRESTapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teacherList = teacherRepository.getAllBy();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }
    public ResponseEntity<Teacher> getTeacherById(Long id) throws TeacherNotFounException {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()){
            return new ResponseEntity<>(teacher.get(),HttpStatus.OK);
        }
        else throw new TeacherNotFounException("teacher with id '" + id + "' not found");
    }

    public ResponseEntity<List<Subject>> getAllSubjectByTeacherId(Long id) throws TeacherNotFounException {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()){
            return new ResponseEntity<>(teacher.get().getSubjectList(),HttpStatus.OK);
        }
        else throw new TeacherNotFounException("teacher with id '" + id +"' not found");
    }


    public HttpStatus createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return HttpStatus.CREATED;
    }
}
