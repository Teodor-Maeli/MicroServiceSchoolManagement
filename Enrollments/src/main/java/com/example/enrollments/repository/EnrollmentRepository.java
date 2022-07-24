package com.example.enrollments.repository;

import com.example.enrollments.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Enrollment findByCourse(String name);

    Enrollment findByStudent(String name);

    Enrollment findByStudentId(Long studentId);
}
