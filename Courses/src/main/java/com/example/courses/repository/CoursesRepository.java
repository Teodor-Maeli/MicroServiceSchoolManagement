package com.example.courses.repository;

import com.example.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Course,Long> {

    Course findCourseByName(String name);
}
