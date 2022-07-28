package com.example.courses.repository;

import com.example.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Course,Long> {

    boolean existsByName(String name);

    boolean existsByTeacherId(Long teacherId);
    List<Course> findAllByTeacherId(Long id);



}
