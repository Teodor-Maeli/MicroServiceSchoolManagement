package com.example.enrollments.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {

    private String course;

    private Long courseId;

    private String student;

    private Long studentId;

    private List<Double> grades;
}
