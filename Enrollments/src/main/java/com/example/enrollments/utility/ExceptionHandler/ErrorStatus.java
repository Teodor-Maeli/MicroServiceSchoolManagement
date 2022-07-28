package com.example.enrollments.utility.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorStatus {

        private LocalDateTime timeStamp;
        private HttpStatus status;
        private String message;
        private String microService;



}
