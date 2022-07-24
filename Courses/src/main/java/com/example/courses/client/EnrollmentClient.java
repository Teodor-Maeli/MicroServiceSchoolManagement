package com.example.courses.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="enrollments-service")

public interface EnrollmentClient {


}
