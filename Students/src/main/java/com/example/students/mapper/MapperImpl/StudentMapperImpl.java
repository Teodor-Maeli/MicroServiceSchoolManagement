package com.example.students.mapper.MapperImpl;

import com.example.students.dto.Request;
import com.example.students.dto.Response;
import com.example.students.entity.Student;
import com.example.students.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@Component
public class StudentMapperImpl implements StudentMapper<Student, Response, Request> {


    @Override
    public Response entityToResponse(Student student) {
        return Response.builder()
                .id(student.getId())
                .age(student.getAge())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }

    @Override
    public List<Response> allEntityToResponse(List<Student> student) {
        List<Response> responses = student.stream().map(this::entityToResponse).toList();
        return responses;
    }

    @Override
    public Student requestToEntity(Request request) {
        return Student.builder()
                .age(request.getAge())
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }
}
