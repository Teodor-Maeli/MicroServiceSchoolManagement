package com.example.enrollments.client;

import com.example.enrollments.pojos.StudentPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "students-service")
public interface StudentFeignClient {

    @GetMapping(value="/students/{studentId}")
    StudentPojo getByStudentId(@PathVariable Long studentId);
}
