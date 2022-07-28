package com.example.teachers.client;


import com.example.teachers.consumers.CoursePojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@FeignClient(name = "COURSES-SERVICE")
public interface CourseFeignClient {


    @GetMapping(value ="courses/teachers/{id}")
    List<CoursePojo> getCourseByTeacherId(@PathVariable(value = "id") Long id);

    @PutMapping(value = "courses/teachers/courses")
    List<CoursePojo> updateTeachersCourses(@RequestBody List<CoursePojo> courses);


    @PutMapping(value = "courses/deleted/{id}")
    String updateCourseByDeletedTeacher(@PathVariable(value = "id") Long id);



}
