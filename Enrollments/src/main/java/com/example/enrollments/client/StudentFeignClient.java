package com.example.enrollments.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENTS-SERVICE")
public interface StudentFeignClient {

    @GetMapping(value="students/name/{id}")
    String getStudentName(@PathVariable(value="id")Long id);
}
