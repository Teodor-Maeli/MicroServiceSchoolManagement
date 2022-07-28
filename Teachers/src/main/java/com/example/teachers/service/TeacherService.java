package com.example.teachers.service;

import com.example.teachers.dto.Request;
import com.example.teachers.dto.Response;
import com.example.teachers.utility.Exceptions.*;

import java.util.List;

public interface TeacherService {

    Response get(Long id) throws ObjectNotFoundException;
    List<Response> getAll() throws EmptyDataBaseException;
    String delete(Long id) throws ObjectNotFoundException;
    Response save(Request request) throws ObjectAlreadyExistException;






}
