package com.example.studentknowledgecontrolsystemRESTapi.service;

import com.example.studentknowledgecontrolsystemRESTapi.exception.SubjectNotFounException;
import com.example.studentknowledgecontrolsystemRESTapi.exception.TestNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Subject;
import com.example.studentknowledgecontrolsystemRESTapi.model.Test;
import com.example.studentknowledgecontrolsystemRESTapi.repository.SubjectRepository;
import com.example.studentknowledgecontrolsystemRESTapi.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;
    private final SubjectRepository subjectRepository;
    @Autowired
    public TestService(TestRepository testRepository, SubjectRepository subjectRepository) {
        this.testRepository = testRepository;
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<Test> getTestBiId(Long testId) throws TestNotFoundException {
        Optional<Test> opt_test = testRepository.findById(testId);

        if(opt_test.isPresent()){
            return new ResponseEntity<>(opt_test.get(), HttpStatus.OK);
        }
        else throw new TestNotFoundException("test with id '"+testId+"' not found ");
    }

    public HttpStatus delete(Long testId) throws TestNotFoundException {
        Optional<Test> opt_test = testRepository.findById(testId);

        if(opt_test.isPresent()){
            testRepository.delete(opt_test.get());
            return HttpStatus.OK;
        }
        else throw new TestNotFoundException("test with id '"+testId+"' not found ");


    }

    public HttpStatus createTest(Long subjectId,Test test) throws SubjectNotFounException {
        Optional<Subject> opt_subject = subjectRepository.findById(subjectId);
        if(opt_subject.isPresent()) {
            test.setSubject(opt_subject.get());
            testRepository.save(test);
            return HttpStatus.CREATED;
        }
        else throw new SubjectNotFounException("Subject with id '"+subjectId+"' not found");


    }

    public ResponseEntity<List<Test>> getAllTestsOfSubject(Long subjectId) throws SubjectNotFounException {
        Optional<Subject> opt_subject = subjectRepository.findById(subjectId);
        if(opt_subject.isPresent()){
            return new ResponseEntity<>(opt_subject.get().getTests(),HttpStatus.OK);
        }
        else throw new SubjectNotFounException("subject with id '"+subjectId+"' not found");

    }
}
