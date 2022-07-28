package com.example.teachers.repository;

import com.example.teachers.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    boolean existsByEmail(String email);

}
