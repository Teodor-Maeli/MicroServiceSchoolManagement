package com.example.students.controllers;

import com.example.students.dto.Request;
import com.example.students.dto.Response;
import com.example.students.service.ServiceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentsController {

    final StudentServiceImpl SERVICE;

    @GetMapping(value ="/{id}")
    public Response get(@PathVariable Long id){
            return SERVICE.get(id);
    }

    @GetMapping(value = "/name/{id}")
    public String getStudentName(@PathVariable Long id){
           return SERVICE.getNameById(id);
    }


    @GetMapping(value = "/all")
    public List<Response> getAll(){
            return SERVICE.getAll();
    }

    @PostMapping
    public Response save(@RequestBody Request request){
            return SERVICE.save(request);
    }


    @PatchMapping
    public Response update(@RequestBody Request request){
            return SERVICE.update(request);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
            return SERVICE.delete(id);
    }



}
