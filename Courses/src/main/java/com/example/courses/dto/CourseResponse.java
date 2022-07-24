package com.example.courses.dto;

import com.example.courses.pojos.EnrollmentPojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {

    private Long id;
    private String name;
    private double duration;
    private String teacher;
    private List<EnrollmentPojo> enrollments;

}
