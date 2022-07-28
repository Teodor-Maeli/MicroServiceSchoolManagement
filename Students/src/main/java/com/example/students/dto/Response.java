package com.example.students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {


    @JsonProperty("STUDENT_ID")
    private Long id;
    @JsonProperty("STUDENT_NAME")
    private String name;
    @JsonProperty("STUDENT_AGE")
    private int age;
    @JsonProperty("STUDENT_EMAIL")
    private String email;
}
