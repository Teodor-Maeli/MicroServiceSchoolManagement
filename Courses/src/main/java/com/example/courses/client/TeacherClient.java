package com.example.courses.client;



import com.example.courses.consumers.TeacherPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "TEACHERS-SERVICE")
public interface TeacherClient {


    @GetMapping(value = "/teachers/{id}")
    TeacherPojo getTeacher(@PathVariable(value="id") Long id);

}
