package com.example.teachers.utility.ExceptionHandler;


import com.example.teachers.utility.Exceptions.EmptyDataBaseException;
import com.example.teachers.utility.Exceptions.ObjectAlreadyExistException;
import com.example.teachers.utility.Exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Handler {


    @ExceptionHandler(value = {EmptyDataBaseException.class})
    public ResponseEntity<ErrorStatus> handler(EmptyDataBaseException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Teachers Service")
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }

    @ExceptionHandler(value = {ObjectAlreadyExistException.class})
    public ResponseEntity<ErrorStatus> handler(ObjectAlreadyExistException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Teachers Service")
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }

    @ExceptionHandler(value = {ObjectNotFoundException.class})
    public ResponseEntity<ErrorStatus> handler(ObjectNotFoundException e) {
        ErrorStatus status = ErrorStatus.builder()
                .timeStamp(LocalDateTime.now())
                .microService("Teachers Service")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(status,status.getStatus());
    }




}
