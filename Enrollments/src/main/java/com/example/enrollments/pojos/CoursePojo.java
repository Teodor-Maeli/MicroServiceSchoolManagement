package com.example.enrollments.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoursePojo {


    private Long id;
    private String name;
    private double duration;
    private String teacher;

}
