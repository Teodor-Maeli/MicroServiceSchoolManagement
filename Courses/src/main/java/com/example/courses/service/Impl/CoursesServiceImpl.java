package com.example.courses.service.Impl;

import com.example.courses.client.EnrollmentFeignClient;
import com.example.courses.client.TeacherClient;
import com.example.courses.consumers.TeacherPojo;
import com.example.courses.dto.Request;
import com.example.courses.dto.Response;
import com.example.courses.entity.Course;
import com.example.courses.mapper.MapperImpl.CourseMapperImpl;
import com.example.courses.repository.CoursesRepository;
import com.example.courses.service.CoursesService;
import com.example.courses.utility.Exceptions.EmptyDataBaseException;
import com.example.courses.utility.Exceptions.ObjectAlreadyExistException;
import com.example.courses.utility.Exceptions.ObjectNotFoundException;
import com.example.courses.utility.Exceptions.TeacherNotAssignedException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.courses.utility.enums.ExceptionMessage.*;
import static com.example.courses.utility.enums.Message.DELETED;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService<Response, Request> {

    final CoursesRepository REPOSITORY;
    final CourseMapperImpl MAPPER;
    final TeacherClient TEACHER_CLIENT;
    final EnrollmentFeignClient ENROLLMENT_CLIENT;


    @Override
    public Response get(Long id) throws ObjectNotFoundException {
        return MAPPER.entityToResponse(REPOSITORY.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(NOT_EXIST.getExceptionMessage())));
    }

    @Override
    public List<Response> getAll() throws EmptyDataBaseException {
        if (!REPOSITORY.findAll().isEmpty()) {
            return MAPPER.allEntityToResponse(REPOSITORY.findAll());
        } else throw new EmptyDataBaseException(EMPTY.getExceptionMessage());
    }

    @Override
    public String getCourseName(Long id) throws ObjectNotFoundException {
        Course course = REPOSITORY.findById(id).orElseThrow(() -> new ObjectNotFoundException(NOT_EXIST.getExceptionMessage()));
        return course.getName();
    }


    @Override
    public List<Response> getByTeacherId(Long id) throws TeacherNotAssignedException {
        List<Course> course = REPOSITORY.findAllByTeacherId(id);
        if (course.isEmpty()) {
            throw new TeacherNotAssignedException(TEACHER_NON_ASSIGNED.getExceptionMessage());
        }
        return MAPPER.allEntityToResponse(course);
    }

    @Override
    public Response save(Request request) throws ObjectAlreadyExistException {
        if (!REPOSITORY.existsByName(request.getName())) {
            Course course = REPOSITORY.save(MAPPER.requestToEntity(request));
            return MAPPER.entityToResponse(course);
        } else throw new ObjectAlreadyExistException(EXIST.getExceptionMessage());
    }

    @Override
    public Response update(Request request) throws ObjectNotFoundException {
        if (REPOSITORY.existsById(request.getId())) {
            return MAPPER.entityToResponse(REPOSITORY.saveAndFlush(MAPPER.requestToEntity(request)));
        } else throw new ObjectNotFoundException(NOT_EXIST.getExceptionMessage());

    }

    @Override
    public String delete(Long id) throws ObjectNotFoundException {
        if (REPOSITORY.existsById(id)) {
            try {
                String message = ENROLLMENT_CLIENT.deleteEnrollments(id);
                REPOSITORY.deleteById(id);
                return message;
            }catch(FeignException e){
                return DELETED.getMessage();            }
        } else throw new ObjectNotFoundException(NOT_EXIST.getExceptionMessage());
    }

    @Override
    public Response assignTeacher(Long cId, Long tId) throws ObjectNotFoundException {
        try {
            TeacherPojo teacher = TEACHER_CLIENT.getTeacher(tId);
            Course course = REPOSITORY.findById(cId).orElseThrow(() -> new ObjectNotFoundException(NOT_EXIST.getExceptionMessage()));
            course.setTeacherId(tId);
            course.setTeacher(teacher.getName());
            return MAPPER.entityToResponse(REPOSITORY.save(course));
        } catch (FeignException e) {
            throw new ObjectNotFoundException(FEIGN_404.getExceptionMessage());
        }
    }


    @Override
    public String updateCourseByDeletedTeacher(Long id) throws ObjectNotFoundException {
        if(REPOSITORY.existsByTeacherId(id)) {
            List<Course> courses = REPOSITORY.findAllByTeacherId(id);
            courses.iterator().next().setTeacherId(null);
            REPOSITORY.saveAll(courses);
            return DELETED.getMessage();
        }else throw new ObjectNotFoundException(TEACHER_NON_ASSIGNED.getExceptionMessage());
    }
}
