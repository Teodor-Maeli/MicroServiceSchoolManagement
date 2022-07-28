package com.example.courses.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {

    private Long id;
    private String name;
    private double duration;

}
