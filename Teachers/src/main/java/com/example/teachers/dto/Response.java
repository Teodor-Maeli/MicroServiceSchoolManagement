package com.example.teachers.dto;


import com.example.teachers.utility.Exceptions.CourseExceptionPojo;
import com.example.teachers.consumers.CoursePojo;
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

    @JsonProperty("TEACHER_ID")
    private Long id;
    @JsonProperty("TEACHER_NAME")
    private String name;
    @JsonProperty("TEACHER_EMAIL")
    private String email;
    @JsonProperty("TEACHER_DEGREE")
    private String degree;
    @JsonProperty("TEACHER_COURSES")
    private List<CoursePojo> course;
    @JsonProperty("COURSES_NOT_FOUND_EXCEPTION")
    private CourseExceptionPojo courseNotFoundException;

}
