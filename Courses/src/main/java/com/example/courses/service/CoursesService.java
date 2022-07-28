package com.example.courses.service;


import com.example.courses.utility.Exceptions.EmptyDataBaseException;
import com.example.courses.utility.Exceptions.ObjectAlreadyExistException;
import com.example.courses.utility.Exceptions.ObjectNotFoundException;
import com.example.courses.utility.Exceptions.TeacherNotAssignedException;

import java.util.List;

public interface CoursesService<T,T1> {

    T get(Long id) throws ObjectNotFoundException;

    List<T> getByTeacherId(Long id) throws TeacherNotAssignedException;

    List<T> getAll() throws EmptyDataBaseException;
    T save(T1 request) throws ObjectAlreadyExistException;
    T update(T1 request) throws ObjectNotFoundException;
    String delete(Long id) throws ObjectNotFoundException;
    T assignTeacher(Long course,Long tId) throws ObjectNotFoundException;

    String getCourseName(Long id);
    String updateCourseByDeletedTeacher(Long id);



}
