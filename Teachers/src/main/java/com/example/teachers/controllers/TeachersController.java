package com.example.teachers.controllers;
import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;
import com.example.teachers.service.serviceImpl.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeachersController {

   final TeacherServiceImpl SERVICE;


    @GetMapping(value ="/{id}")
    public Response getTeacher(@PathVariable Long id) {
            return SERVICE.get(id);
    }

    @GetMapping(value ="/all")
    public List<Response> getAllTeachers() {
            return SERVICE.getAll();
    }

    @DeleteMapping(value ="/{id}")
    public String deleteTeacher(@PathVariable Long id) {
            return SERVICE.delete(id);
    }

    @PostMapping
    public Response saveTeacher(@RequestBody Request teacher) {
            return SERVICE.save(teacher);
    }



}
