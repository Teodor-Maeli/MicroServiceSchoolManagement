package com.example.courses.mapper;

import com.example.courses.dto.CourseRequest;
import com.example.courses.dto.CourseResponse;
import com.example.courses.entity.Course;

public interface CourseMapper {

    CourseResponse entityToResponse(Course entity);
    CourseResponse RequestToEntity(CourseRequest request);


}
