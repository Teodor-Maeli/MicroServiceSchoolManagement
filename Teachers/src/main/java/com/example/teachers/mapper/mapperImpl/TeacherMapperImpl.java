package com.example.teachers.mapper.mapperImpl;

import com.example.teachers.client.CourseFeignClient;
import com.example.teachers.utility.Exceptions.CourseExceptionPojo;
import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;
import com.example.teachers.entity.Teacher;
import com.example.teachers.mapper.TeacherMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.teachers.utility.enums.ExceptionMessage.*;


@Component
@RequiredArgsConstructor
public class TeacherMapperImpl implements TeacherMapper<Teacher> {

    final CourseFeignClient CLIENT;

    @Override
    public Response entityToResponse(Teacher teacher) {
        try {
            return Response.builder()
                    .id(teacher.getId())
                    .name(teacher.getName())
                    .email(teacher.getEmail())
                    .degree(teacher.getDegree())
                    .course(CLIENT.getCourseByTeacherId(teacher.getId()))
                    .build();
        } catch (FeignException e) {
            return Response.builder()
                    .id(teacher.getId())
                    .name(teacher.getName())
                    .email(teacher.getEmail())
                    .degree(teacher.getDegree())
                    .courseNotFoundException(CourseExceptionPojo.builder()
                            .microService(SERVICE.getEXCEPTION_MESSAGE())
                            .timeStamp(LocalDateTime.now())
                            .message(NOT_FOUND.getEXCEPTION_MESSAGE())
                            .status(404)
                            .build())
                    .build();
        }
    }

    @Override
    public List<Response> allEntityToResponse(List<Teacher> teachers) {
        List<Response> responses = teachers.stream().map(this::entityToResponse).toList();
        return responses;
    }

    @Override
    public Teacher requestToEntity(Request request) {
        return Teacher.builder()
                .name(request.getName())
                .email(request.getEmail())
                .degree(request.getDegree())
                .build();

    }


}
