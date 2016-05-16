package com.lindec.springboot.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by lindec on 2016/5/5.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorResponseFactory errorResponseFactory;

    public RestResponseEntityExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(value = {testException.class})
    public ResponseEntity<Object> handleCannotBindOtherManufacturerDeviceException(testException ex, WebRequest request) {

        ErrorResponse bodyOfResponse = errorResponseFactory.getErrorResponse(ErrorMap.
                ERROR_WEB_API_CLIENT_ONLY_OWNER_CAN_AUTH_ERROR, request.getLocale(), ex.getMessage());
        return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
