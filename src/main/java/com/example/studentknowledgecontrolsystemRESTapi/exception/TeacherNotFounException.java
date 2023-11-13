package com.example.studentknowledgecontrolsystemRESTapi.exception;

import org.springframework.http.HttpStatus;

public class TeacherNotFounException extends Throwable {
    private String message;
    private HttpStatus httpStatus;
    public TeacherNotFounException(String s) {
        super(s);
    }
    public TeacherNotFounException(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;


    }
}
