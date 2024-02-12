package com.api.assessment.exception;

import org.springframework.http.HttpStatus;

import java.net.http.HttpRequest;
import java.time.ZonedDateTime;

public class CustomerException {
    private final String message;
    //private final Throwable throwable;
    private final HttpStatus httpRequest;
    private final ZonedDateTime zonedDateTime;

    public CustomerException(String message, Throwable throwable, HttpStatus httpRequest, ZonedDateTime zonedDateTime) {
        this.message = message;
       // this.throwable = throwable;
        this.httpRequest = httpRequest;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage() {
        return message;
    }

//    public Throwable getThrowable() {
//        return throwable;
//    }

    public HttpStatus getHttpRequest() {
        return httpRequest;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
