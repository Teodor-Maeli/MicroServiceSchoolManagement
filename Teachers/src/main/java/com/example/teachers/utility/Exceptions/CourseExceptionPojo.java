package com.example.teachers.utility.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CourseExceptionPojo {

    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String microService;
}
