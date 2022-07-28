package com.example.teachers.service.serviceImpl;

import com.example.teachers.client.CourseFeignClient;
import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;
import com.example.teachers.mapper.mapperImpl.TeacherMapperImpl;
import com.example.teachers.repository.TeacherRepository;
import com.example.teachers.service.TeacherService;
import com.example.teachers.utility.Exceptions.EmptyDataBaseException;
import com.example.teachers.utility.Exceptions.ObjectAlreadyExistException;
import com.example.teachers.utility.Exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.teachers.utility.enums.ExceptionMessage.*;
import static com.example.teachers.utility.enums.Message.DELETED;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    final TeacherRepository REPOSITORY;
    final TeacherMapperImpl MAPPER;
    final CourseFeignClient CLIENT;


    @Override
    public Response get(Long id) throws ObjectNotFoundException {
        return MAPPER.entityToResponse(REPOSITORY.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(NOT_EXIST.name())));
    }


    @Override
    public List<Response> getAll() throws EmptyDataBaseException {
        if (!REPOSITORY.findAll().isEmpty()) {
            return MAPPER.allEntityToResponse(REPOSITORY.findAll());
        } else throw new EmptyDataBaseException(EMPTY.name());
    }

    @Override
    public String delete(Long id) throws ObjectNotFoundException {
        if (REPOSITORY.existsById(id)) {
            try{
                CLIENT.updateCourseByDeletedTeacher(id);
                REPOSITORY.deleteById(id);
                return DELETED.getMESSAGE();
            }catch(FeignException e){
              return FAILED.getEXCEPTION_MESSAGE();
            }
        } else throw new ObjectNotFoundException(NOT_EXIST.name());
    }

    @Override
    public Response save(Request request) throws ObjectAlreadyExistException {
        if (!REPOSITORY.existsByEmail(request.getName())) {
            return MAPPER.entityToResponse(REPOSITORY.save(MAPPER.requestToEntity(request)));
        } else throw new ObjectAlreadyExistException(EXIST.name());
    }


}
