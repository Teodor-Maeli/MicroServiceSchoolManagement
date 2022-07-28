package com.example.students.service.ServiceImpl;


import com.example.students.client.EnrollmentFeignClient;
import com.example.students.dto.Request;
import com.example.students.dto.Response;
import com.example.students.entity.Student;
import com.example.students.mapper.MapperImpl.StudentMapperImpl;
import com.example.students.repository.StudentRepository;
import com.example.students.service.StudentService;
import com.example.students.utility.Exceptions.EmptyDataBaseException;
import com.example.students.utility.Exceptions.ObjectAlreadyExistException;
import com.example.students.utility.Exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.students.utility.enums.ExceptionMessage.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService<Response, Request> {


   final StudentMapperImpl MAPPER;
   final StudentRepository REPOSITORY;
   final EnrollmentFeignClient CLIENT;


    @Override
    public Response get(Long id) throws ObjectNotFoundException {
        return MAPPER.entityToResponse(REPOSITORY.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(NOT_EXIST.getExceptionMessage())));
    }

    public String getNameById(Long id) throws ObjectNotFoundException {

        Student student = REPOSITORY.findById(id).orElseThrow(()-> new ObjectNotFoundException(NOT_EXIST.getExceptionMessage()));
        return student.getName();
    }

    @Override
    public List<Response> getAll() throws EmptyDataBaseException {
        if (!REPOSITORY.findAll().isEmpty()) {
            return MAPPER.allEntityToResponse(REPOSITORY.findAll());
        } else throw new EmptyDataBaseException(EMPTY.getExceptionMessage());
    }

    @Override
    public Response save(Request request) throws ObjectAlreadyExistException {
        if (!REPOSITORY.existsByEmail(request.getEmail())) {
            return MAPPER.entityToResponse(REPOSITORY.save(MAPPER.requestToEntity(request)));
        } else throw new ObjectAlreadyExistException(EXIST.getExceptionMessage());
    }

    @Override
    public Response update(Request request) throws ObjectNotFoundException {
        if(REPOSITORY.existsByEmail(request.getEmail())) {
            return MAPPER.entityToResponse(REPOSITORY.save(MAPPER.requestToEntity(request)));
        }else throw new ObjectNotFoundException(NOT_EXIST.getExceptionMessage());
    }

    @Override
    public String delete(Long id) throws ObjectNotFoundException {
        if(REPOSITORY.existsById(id)){
            try {
               String message = CLIENT.deleteEnrollments(id);
                REPOSITORY.deleteById(id);
                return message;
            }catch(FeignException e){
                return DELETED.getExceptionMessage();
            }
        }else throw new ObjectNotFoundException(NOT_EXIST.getExceptionMessage());
    }



}
