package com.example.students.service.ServiceImpl;

import com.example.students.client.EnrollmentFeignClient;
import com.example.students.dto.Request;
import com.example.students.dto.Response;
import com.example.students.entity.Student;
import com.example.students.mapper.MapperImpl.StudentMapperImpl;
import com.example.students.repository.StudentRepository;
import com.example.students.utility.Exceptions.EmptyDataBaseException;
import com.example.students.utility.Exceptions.ObjectAlreadyExistException;
import com.example.students.utility.Exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ctc.wstx.shaded.msv_core.grammar.Expression.anyString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    StudentRepository repository;
    @Mock
    StudentMapperImpl mapper;
    @Mock
    EnrollmentFeignClient client;
    StudentServiceImpl service;
    Student student;
    Response response;

    Request request;

    @BeforeEach
    void setup(){
        service = new StudentServiceImpl(mapper, repository, client);
        student = Student.builder()
                .id(1L)
                .email("1L")
                .name("1")
                .age(1)
                .build();

        response = Response.builder()
                .id(1L)
                .email("1")
                .name("1")
                .age(1)
                .build();

        request = Request.builder()
                .id(1L)
                .age(1)
                .email("1")
                .name("1")
                .build();

    }


    @Test
    void get() {
        service = new StudentServiceImpl(mapper, repository, client);
    }

    @Test
    void getNameById() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(student));
        when(mapper.entityToResponse(student)).thenReturn(response);
        assertAll(
                ()->assertNotNull(service.get(anyLong())),
                ()->assertEquals(service.get(anyLong()), response),
                ()-> assertEquals("1", service.get(anyLong()).getName()));

    }

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(student));
        when(mapper.allEntityToResponse(repository.findAll())).thenReturn(List.of(response));
        assertAll(
                ()->assertNotNull(service.getAll()),
                ()->assertEquals(service.getAll(), List.of(response)),
                ()->assertEquals(service.getAll().size(),1));

    }
    @Test
    void getAllThrows(){
        List emptyList = new ArrayList();
        when(repository.findAll()).thenReturn(emptyList);
        assertThrows(EmptyDataBaseException.class,()->service.getAll());
    }

    @Test
    void save() {
        when(repository.existsByEmail(anyString())).thenReturn(false);
        when(mapper.entityToResponse(repository.save(mapper.requestToEntity(request)))).thenReturn(response);
        assertAll(
                ()->assertEquals(service.save(request),response),
                ()->assertNotNull(service.save(request)),
                ()->assertEquals(service.save(request).getEmail(),"1"));

    }

    @Test
    void saveThrows(){
        when(repository.existsByEmail(anyString())).thenReturn(true);
        assertThrows(ObjectAlreadyExistException.class,()->service.save(request));
    }

    @Test
    void update() {
        when(repository.existsByEmail(anyString())).thenReturn(true);
        when(mapper.entityToResponse(repository.save(mapper.requestToEntity(request))))
                .thenReturn(response);
        assertAll(
                ()->assertNotNull(service.update(request)),
                ()->assertEquals(service.update(request),response),
                ()-> assertEquals("1", service.update(request).getEmail()));
    }

    @Test
    void updateThrows(){
        when(repository.existsByEmail(anyString())).thenReturn(false);
        assertThrows(ObjectNotFoundException.class,()->service.update(request));
    }

    @Test
    void delete() {
        when(repository.existsById(anyLong())).thenReturn(false);
        assertThrows(ObjectNotFoundException.class,()->service.delete(anyLong()));
    }
}