package com.example.enrollments.pojos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPojo {


    private Long id;
    private String name;
    private int age;
    private String email;

}
