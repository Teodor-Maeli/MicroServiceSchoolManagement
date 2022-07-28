package com.example.courses.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENROLLMENTS-SERVICE")
public interface EnrollmentFeignClient {


    @DeleteMapping(value= "/enrollments/{id}")
    String  deleteEnrollments(@PathVariable(value = "id") Long id);
}
