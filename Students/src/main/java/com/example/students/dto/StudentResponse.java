package com.example.students.dto;

import com.example.students.pojos.EnrollmentPojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private int age;
    private String email;
    private List<EnrollmentPojo> enrollments;
}
