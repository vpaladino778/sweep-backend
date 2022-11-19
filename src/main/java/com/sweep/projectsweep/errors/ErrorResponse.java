package com.sweep.projectsweep.errors;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class ErrorResponse {

    private final HttpStatusCode httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public ErrorResponse(ApiException exception) {
        this.httpStatus = exception.getStatusCode();
        this.errorCode = exception.getErrorCode();
        this.errorMessage = exception.getMessage();
    }



}
