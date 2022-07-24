package com.example.enrollments.client;


import com.example.enrollments.pojos.CoursePojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "courses-service")
public interface CourseFeignClient {

    @GetMapping(value = "courses/{name}")
    CoursePojo getCourse(@PathVariable String name);


}
