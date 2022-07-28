package com.example.students.service;

import com.example.students.utility.Exceptions.EmptyDataBaseException;
import com.example.students.utility.Exceptions.ObjectAlreadyExistException;
import com.example.students.utility.Exceptions.ObjectNotFoundException;

import java.util.List;

public interface StudentService<T, T1> {


    T get(Long id) throws ObjectNotFoundException;

    List<T> getAll() throws EmptyDataBaseException;

    T save(T1 request) throws ObjectAlreadyExistException;

    T update(T1 request) throws ObjectNotFoundException;

    String delete(Long id) throws ObjectNotFoundException;




}
