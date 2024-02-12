package com.api.assessment.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class APIException {
    private final String message;
    //private final Throwable throwable;
    private final HttpStatus httpRequest;
    private final ZonedDateTime zonedDateTime;

    public APIException(String message, HttpStatus httpRequest, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.httpRequest = httpRequest;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpRequest() {
        return httpRequest;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
