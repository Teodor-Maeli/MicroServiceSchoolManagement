package com.example.teachers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private Long id;
    private String name;
    private String email;
    private String degree;
}
