package com.example.courses.mapper.MapperImpl;


import com.example.courses.client.TeacherClient;
import com.example.courses.dto.Request;
import com.example.courses.dto.Response;
import com.example.courses.entity.Course;
import com.example.courses.mapper.CourseMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CourseMapperImpl implements CourseMapper<Response, Course, Request> {

    @JsonProperty
    @Override
    public Response entityToResponse(Course course) {
        return Response.builder()
                .id(course.getId())
                .name(course.getName())
                .duration(course.getDuration())
                .teacherId(course.getTeacherId())
                .teacher(course.getTeacher())
                .build();
    }

    @Override
    public List<Response> allEntityToResponse(List<Course> entities) {
        List<Response> responses = entities.stream().map(this::entityToResponse).toList();
        return responses;
    }


    @Override
    public Course requestToEntity(Request request) {
        return Course.builder()
                .name(request.getName())
                .duration(request.getDuration())
                .build();
    }

    @Override
    public List<Course> allRequestToEntity(List<Request> requests) {
        List<Course> entities = requests.stream().map(this::requestToEntity).toList();
        return entities;
    }


}
