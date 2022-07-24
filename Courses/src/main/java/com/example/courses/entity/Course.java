package com.example.courses.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_duration")
    private double duration;
    @Column(name = "course_teacher")
    private String teacher;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course courses = (Course) o;
        return name.equals(courses.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
