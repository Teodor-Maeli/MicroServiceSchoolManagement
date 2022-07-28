package com.example.courses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty("COURSE_ID")
    private Long id;
    @JsonProperty("COURSE_NAME")
    private String name;
    @JsonProperty("COURSE_DURATION")
    private double duration;
    @JsonProperty("TEACHER_ID")
    private Long teacherId;
    @JsonProperty("TEACHER_NAME")
    private String teacher;

}
