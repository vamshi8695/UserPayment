package com.crm.crm_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //A combination of @ControllerAdvice and @ResponseBody to handle exceptions globally and return JSON responses.
public class GlobalExceptionHandler {

    // Handling UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class) //Used to catch specific exceptions (like UserNotFoundException).
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handling all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        //Helps return custom HTTP status codes along with the response body.
        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
