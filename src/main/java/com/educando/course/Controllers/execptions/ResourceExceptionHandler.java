package com.educando.course.Controllers.execptions;

import com.educando.course.services.exception.DatabaseException;
import com.educando.course.services.exception.ResourceByNameNotFound;
import com.educando.course.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.dialect.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
    /*
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
     */
        return new ResponseEntity<>(StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Resource not found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e,HttpServletRequest request){
        /*
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
         */
        return new ResponseEntity<>(StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Database Error")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceByNameNotFound.class)
    public ResponseEntity<StandardError> resourceByNameNotFound(ResourceByNameNotFound e, HttpServletRequest request){
     /*  String error = "Resource by name not found";
       HttpStatus status = HttpStatus.NOT_FOUND;
       StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
       return ResponseEntity.status(status).body(err);

      */
        return new ResponseEntity<>(StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Resource by name not found")
                .message(e.getMessage())
                .path(request.getRequestURI()).build(),HttpStatus.NOT_FOUND);
    }
}



