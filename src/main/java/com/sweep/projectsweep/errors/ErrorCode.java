package com.sweep.projectsweep.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    PROFILE_001(HttpStatus.BAD_REQUEST, "Cannot find profile with id %sq"),
    PROFILE_002(HttpStatus.BAD_REQUEST, "Invalid profile ID");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorMessage){
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return this.name();
    }
}
