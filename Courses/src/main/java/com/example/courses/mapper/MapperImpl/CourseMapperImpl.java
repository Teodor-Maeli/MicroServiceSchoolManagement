package com.example.courses.mapper.MapperImpl;

import com.example.courses.mapper.CourseMapper;
import com.example.courses.dto.CourseRequest;
import com.example.courses.dto.CourseResponse;
import com.example.courses.entity.Course;
import feign.Client;

public class CourseMapperImpl implements CourseMapper {

    private Client client;

    @Override
    public CourseResponse entityToResponse(Course entity) {
        return CourseResponse.builder()

                .build();
    }

    @Override
    public CourseResponse RequestToEntity(CourseRequest request) {
        return null;
    }
}
