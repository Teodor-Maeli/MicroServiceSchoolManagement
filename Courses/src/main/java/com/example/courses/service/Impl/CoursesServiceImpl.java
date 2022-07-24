package com.example.courses.service.Impl;

import com.example.courses.dto.CourseRequest;
import com.example.courses.dto.CourseResponse;
import com.example.courses.repository.CoursesRepository;
import com.example.courses.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    CoursesRepository repository;

    @Override
    public CourseResponse getCourses(Long id) {
        return null;
    }

    @Override
    public CourseResponse getCourseByStudent(Long id) {
        return null;
    }

    @Override
    public CourseResponse save(CourseRequest request) {
        return null;
    }

    @Override
    public CourseResponse update(CourseRequest request) {
        return null;
    }

    @Override
    public CourseResponse delete(Long id) {
        return null;
    }
}
