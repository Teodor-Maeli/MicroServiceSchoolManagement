package com.example.enrollments.consumers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoursePojo {


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
