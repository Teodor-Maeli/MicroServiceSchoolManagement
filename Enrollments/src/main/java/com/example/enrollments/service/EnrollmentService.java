package com.example.enrollments.service;

import com.example.enrollments.utility.Exceptions.InvalidGradeException;
import com.example.enrollments.utility.Exceptions.ObjectAlreadyEnrolledException;
import com.example.enrollments.utility.Exceptions.ObjectNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public interface EnrollmentService<T> {

    List<T> getStudentEnrollments(Long id) throws ObjectNotFoundException;

    T assignStudentToCourse(Long cId,Long sId) throws ObjectNotFoundException, ObjectAlreadyEnrolledException;

    List<T> getAll();

    T addGrade(Long cid,Long sid,double grade) throws ObjectNotFoundException, InvalidGradeException;

    HashMap<String, Double> courseTotalAverage(Long cId) throws ObjectNotFoundException;
    HashMap<String, Double> studentTotalAverage(Long sId) throws ObjectNotFoundException;

    TreeMap<String, TreeMap<String,Double>> showAllGroupedByCourse();




}
