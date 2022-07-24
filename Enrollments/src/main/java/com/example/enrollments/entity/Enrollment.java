package com.example.enrollments.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Course_Name")
    private String course;
    @Column(name = "Course_ID")
    private Long courseId;
    @Column(name = "Student_Name")
    private String student;
    @Column(name = "Student ID")
    private Long studentId;
    @ElementCollection
    private List<Double> grades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return courseId.equals(that.courseId) && studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
