package com.example.enrollments.dto;


import com.example.enrollments.utility.Exceptions.EntityExceptionPojo;
import com.example.enrollments.consumers.CoursePojo;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {


    @JsonProperty("ENROLLMENT_ID")
    private Long enrollmentId;
    @JsonProperty("STUDENT_ID")
    private Long studentId;
    @JsonProperty("STUDENT_NAME")
    private String student;
    @JsonProperty("COURSE_DETAILS")
    private CoursePojo course;
    @JsonProperty("COURSE_SERVICE_NOT_RESPOND")
    private EntityExceptionPojo entityNotFoundException;
    @JsonProperty("STUDENT_GRADES")
    private List<Double> grades;


}
