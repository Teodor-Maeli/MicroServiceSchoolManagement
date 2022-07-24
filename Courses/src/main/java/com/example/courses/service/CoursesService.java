package com.example.courses.service;

import com.example.courses.dto.CourseRequest;
import com.example.courses.dto.CourseResponse;

public interface CoursesService {

    CourseResponse getCourses(Long id);
    CourseResponse getCourseByStudent(Long id);
    CourseResponse save(CourseRequest request);
    CourseResponse update(CourseRequest request);
    CourseResponse delete(Long id);

}
