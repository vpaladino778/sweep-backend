package com.sweep.projectsweep.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {


    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    protected ErrorResponse handleApiException(ApiException exception) {
        return new ErrorResponse(exception);
    }
}
