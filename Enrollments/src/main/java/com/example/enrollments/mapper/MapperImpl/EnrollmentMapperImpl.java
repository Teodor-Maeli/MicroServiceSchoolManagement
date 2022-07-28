package com.example.enrollments.mapper.MapperImpl;

import com.example.enrollments.client.CourseFeignClient;
import com.example.enrollments.client.StudentFeignClient;
import com.example.enrollments.utility.Exceptions.EntityExceptionPojo;
import com.example.enrollments.dto.Response;
import com.example.enrollments.entity.Enrollment;
import com.example.enrollments.mapper.EnrollmentMapper;

import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.enrollments.utility.enums.ExceptionMessage.DEPENDABLE_SERVICE;
import static com.example.enrollments.utility.enums.ExceptionMessage.SERVICES;

@AllArgsConstructor
@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    CourseFeignClient courseClient;
    StudentFeignClient studentClient;

    @Override
    public Response entityToResponse(Enrollment enrollment) {
        try {
            return Response.builder()
                    .enrollmentId(enrollment.getId())
                    .course(courseClient.getCourse(enrollment.getCourseId()))
                    .student(enrollment.getStudentName())
                    .studentId(enrollment.getStudentId())
                    .grades(enrollment.getGrades())
                    .build();
        }catch (FeignException e) {
            return   Response.builder()
                    .enrollmentId(enrollment.getId())
                    .entityNotFoundException(EntityExceptionPojo.builder()
                            .message(DEPENDABLE_SERVICE.getExceptionMessage())
                            .Service(SERVICES.getExceptionMessage())
                            .status(404)
                            .timeStamp(LocalDateTime.now())
                            .build())
                    .studentId(enrollment.getStudentId())
                    .grades(enrollment.getGrades())
                    .build();
        }
    }

    @Override
    public List<Response> allEntityToResponse(List<Enrollment> enrollments) {
        List<Response> responses = enrollments.stream().map(this::entityToResponse).toList();
        return responses;

    }


}
