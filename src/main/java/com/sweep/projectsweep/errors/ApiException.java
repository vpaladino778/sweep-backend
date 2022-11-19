package com.sweep.projectsweep.errors;

import lombok.Getter;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class ApiException extends ResponseStatusException {

    private String errorCode;

    public ApiException(ErrorCode errorCode, String errorMessage) {
        super(errorCode.getHttpStatus(), String.format(errorCode.getErrorMessage(), errorMessage));
        this.errorCode = errorCode.getErrorCode();
    }

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getHttpStatus());
        this.errorCode = errorCode.getErrorCode();
    }

}
