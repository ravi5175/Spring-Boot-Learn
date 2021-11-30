package com.learn.boot.project.exception;

import com.learn.boot.project.exception.error_response_entity.ErrorResponse;

import com.learn.boot.project.exception.custom_exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(
        UserNotFoundException userNotFoundException,
        WebRequest request){
            ErrorResponse message = new ErrorResponse(HttpStatus.NOT_FOUND,"User Not Found");

            return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(message);
        }
}
