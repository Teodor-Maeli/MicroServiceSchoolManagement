package com.example.enrollments.mapper;

import com.example.enrollments.dto.Response;
import com.example.enrollments.entity.Enrollment;

import java.util.List;

public interface EnrollmentMapper {

    Response entityToResponse(Enrollment enrollment);

    List<Response> allEntityToResponse(List<Enrollment> enrollments);


}
