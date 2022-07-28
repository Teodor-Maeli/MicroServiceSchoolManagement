package com.example.teachers.mapper;

import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;

import java.util.List;


public interface TeacherMapper<T> {

    Response entityToResponse(T teachers);
    List<Response> allEntityToResponse(List<T> teachers);
    T requestToEntity(Request request);
}
