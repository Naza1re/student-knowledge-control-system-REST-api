package com.example.studentknowledgecontrolsystemRESTapi.controller;

import com.example.studentknowledgecontrolsystemRESTapi.exception.SubjectNotFounException;
import com.example.studentknowledgecontrolsystemRESTapi.exception.TestNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Test;
import com.example.studentknowledgecontrolsystemRESTapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects/{subject_id}")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/{test_id}")
    public ResponseEntity<Test> getTest(@PathVariable Long test_id, @PathVariable String subject_id) throws TestNotFoundException {
        return testService.getTestBiId(test_id);
    }
    @DeleteMapping("/{test_id}/delete")
    public HttpStatus deleteTest(@PathVariable Long test_id, @PathVariable String subject_id) throws TestNotFoundException {
        return testService.delete(test_id);
    }
    @PostMapping("/create")
    public HttpStatus createTest(@RequestBody Test test, @PathVariable Long subject_id) throws SubjectNotFounException {
        return testService.createTest(subject_id,test);
    }
    @GetMapping("/all-tests")
    public ResponseEntity<List<Test>> getAllTestOfSubject(@PathVariable Long subject_id) throws SubjectNotFounException {
        return testService.getAllTestsOfSubject(subject_id);
    }


}
