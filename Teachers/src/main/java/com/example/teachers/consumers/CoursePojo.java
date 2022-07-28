package com.example.teachers.consumers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursePojo {

    @JsonProperty("COURSE_ID")
    private Long id;
    @JsonProperty("COURSE_NAME")
    private String name;
    @JsonProperty("COURSE_DURATION")
    private double duration;


}
