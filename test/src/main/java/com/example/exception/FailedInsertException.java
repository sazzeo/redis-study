package com.example.exception;

public class FailedInsertException extends RuntimeException {

    public FailedInsertException() {
        super("insert 실패");
    }
}
