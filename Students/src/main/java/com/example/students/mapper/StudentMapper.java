package com.example.students.mapper;

import java.util.List;

public interface StudentMapper<T, T1, T2> {


    T1 entityToResponse(T teachers);

    List<T1> allEntityToResponse(List<T> teachers);

    T requestToEntity(T2 request);

}
