package com.example.enrollments.repository;

import com.example.enrollments.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

   Optional<List<Enrollment>> findAllByCourseId(Long id);

    Optional<List<Enrollment>> findAllByStudentId(Long id);

    boolean existsByStudentId(Long id);

    boolean existsByCourseId(Long id);

    Optional<Enrollment> findByCourseIdAndStudentId(Long courseId, Long studentId);

    boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);

    void deleteAllByCourseId(Long courseId);
    void deleteAllByStudentId(Long studentId);

}
