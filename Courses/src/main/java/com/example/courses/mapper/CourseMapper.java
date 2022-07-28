package com.example.courses.mapper;

import java.util.List;

public interface CourseMapper<T,T1,T2> {

    T entityToResponse(T1 entity);

    List<T> allEntityToResponse(List<T1> entities);
    T1  requestToEntity(T2 request);

    List<T1> allRequestToEntity(List<T2> entities);



}
