package com.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(FailedInsertException.class)
    public String failedInsertException(FailedInsertException e) {
        return e.getMessage();
    }
}
