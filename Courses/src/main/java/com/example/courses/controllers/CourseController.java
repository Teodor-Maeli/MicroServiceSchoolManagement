package com.example.courses.controllers;

import com.example.courses.dto.Request;
import com.example.courses.dto.Response;
import com.example.courses.service.Impl.CoursesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@AllArgsConstructor
public class CourseController {

    private final CoursesServiceImpl SERVICE;

    @GetMapping(value = "/{id}")
    public Response getCourse(@PathVariable Long id) {
            return SERVICE.get(id);
    }

    @GetMapping(value="/all")
    public List<Response> getAllCourses() {
            return SERVICE.getAll();
    }

    @GetMapping(value = "/name/{id}")
    public String getCourseName(@PathVariable Long id) {
           return SERVICE.getCourseName(id);
    }

    @GetMapping(value = "/teachers/{id}")
    List<Response> getByTeacherAssigned(@PathVariable Long id) {
            return SERVICE.getByTeacherId(id);
    }

    @PostMapping
    public Response save(@RequestBody Request request) {
            return SERVICE.save(request);
    }

    @PatchMapping
    public Response update(@RequestBody Request request) {
            return SERVICE.update(request);
    }

    @PostMapping(value = "/{cId}/{tId}")
    public Response assignTeacher(@PathVariable Long cId, @PathVariable Long tId) {
            return SERVICE.assignTeacher(cId, tId);
    }

    @PutMapping(value = "/deleted/{id}")
    String updateCourseByDeletedTeacher(@PathVariable(value = "id") Long id){
            return SERVICE.updateCourseByDeletedTeacher(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
            return SERVICE.delete(id);
    }




}
