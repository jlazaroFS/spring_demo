package com.prueba.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.demo.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { UserServiceException.class })
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
