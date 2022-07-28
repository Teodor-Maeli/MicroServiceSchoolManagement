package com.example.enrollments.client;


import com.example.enrollments.consumers.CoursePojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSES-SERVICE")
public interface CourseFeignClient {

    @GetMapping(value = "courses/{id}")
    CoursePojo getCourse(@PathVariable(value = "id") Long id);

    @GetMapping(value = "courses/name/{id}")
    String getName(@PathVariable(value = "id") Long id);


}
