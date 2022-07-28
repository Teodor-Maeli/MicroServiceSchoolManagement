package com.example.teachers.service.serviceImpl;

import com.example.teachers.client.CourseFeignClient;
import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;
import com.example.teachers.entity.Teacher;
import com.example.teachers.mapper.mapperImpl.TeacherMapperImpl;
import com.example.teachers.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.teachers.utility.enums.Message.DELETED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    TeacherRepository repository;
    @Mock
    TeacherMapperImpl mapper;
    @Mock
    CourseFeignClient courseClient;

    TeacherServiceImpl service;

    Teacher teacher;
    Response response;
    Request request;

    @BeforeEach
    void setup() {
        service = new TeacherServiceImpl(repository, mapper, courseClient);
        teacher = Teacher.builder()
                .id(1L)
                .email("1")
                .degree("1")
                .name("1")
                .build();

        response = Response.builder()
                .id(1L)
                .email("1")
                .name("1")
                .degree("1")
                .build();

        request = Request.builder()
                .email("1")
                .id(1L)
                .name("1")
                .degree("1")
                .build();
    }

    @Test
    void get() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(teacher));
        when(mapper.entityToResponse(any(Teacher.class))).thenReturn(response);
        assertAll(
                () -> assertEquals(service.get(anyLong()), response),
                () -> assertNotNull(service.get(anyLong())),
                () -> assertSame("1", service.get(anyLong()).getDegree()),
                () -> assertSame("1", service.get(anyLong()).getDegree()),
                () -> assertNotEquals(service.get(anyLong()), teacher));


    }

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(teacher));
        when(mapper.allEntityToResponse(anyList())).thenReturn(List.of(response));
        assertAll(
                () -> assertEquals(service.getAll(), List.of(response)),
                () -> assertNotNull(service.getAll()),
                () -> assertNotSame(service.getAll(), List.of(teacher)),
                () -> assertEquals("1", service.getAll().get(0).getDegree()));
    }

    @Test
    void delete() {
        when(repository.existsById(anyLong())).thenReturn(true);
        assertAll(
                () -> assertEquals(service.delete(anyLong()), DELETED.getMESSAGE()),
                () -> assertNotNull(service.delete(anyLong())),
                () -> assertTrue(service.delete(anyLong()).contains("DELETED")));
    }

    @Test
    void save() {
        when(repository.existsByEmail(anyString())).thenReturn(false);
        when(mapper.entityToResponse(repository.save(mapper.requestToEntity(any(Request.class)))))
                .thenReturn(response);
        assertAll(
                ()-> assertEquals(service.save(request),response),
                ()->assertNotNull(service.save(request)),
                ()->assertTrue(service.save(request).getDegree().equals("1")),
                ()->assertTrue(service.save(request).getCourse()==null));

    }
}