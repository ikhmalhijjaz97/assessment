package com.api.assessment.exception;

public class APIErrorException extends RuntimeException{
    public APIErrorException(String message) {
        super(message);
    }

    public APIErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
