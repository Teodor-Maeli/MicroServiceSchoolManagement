package com.example.enrollments.utility.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class EntityExceptionPojo {

    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String Service;
}
