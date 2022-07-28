package com.example.enrollments.utility.ExceptionHandler;


import com.example.enrollments.utility.Exceptions.InvalidGradeException;
import com.example.enrollments.utility.Exceptions.ObjectAlreadyEnrolledException;
import com.example.enrollments.utility.Exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Handler {


    @ExceptionHandler(value = {InvalidGradeException.class})
    public ResponseEntity<ErrorStatus> handler(InvalidGradeException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Enrollments Service")
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }

    @ExceptionHandler(value = {ObjectAlreadyEnrolledException.class})
    public ResponseEntity<ErrorStatus> handler(ObjectAlreadyEnrolledException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Enrollments Service")
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }

    @ExceptionHandler(value = {ObjectNotFoundException.class})
    public ResponseEntity<ErrorStatus> handler(ObjectNotFoundException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Enrollments Service")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }




}
