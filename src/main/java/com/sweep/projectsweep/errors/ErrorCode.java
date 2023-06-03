package com.sweep.projectsweep.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    PROFILE_001(HttpStatus.BAD_REQUEST, "Cannot find profile with id %s"),
    PROFILE_002(HttpStatus.BAD_REQUEST, "Invalid profile ID: {}"),
    AVAILABILITY_001(HttpStatus.BAD_REQUEST, "Invalid mentorId: %s"),
    USER_MANAGEMENT_001(HttpStatus.INTERNAL_SERVER_ERROR,"Firebase authentication error while creating user %s"),
    USER_MANAGEMENT_002(HttpStatus.BAD_REQUEST, "Mentor not found with id %s");


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
