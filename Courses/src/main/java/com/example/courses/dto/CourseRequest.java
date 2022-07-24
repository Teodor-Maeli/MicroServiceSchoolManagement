package com.example.courses.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {

    private String name;
    private double duration;
    private String teacher;
    private List<?> enrollments;
}
