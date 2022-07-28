package com.example.courses.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private double duration;
    private Long teacherId;
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
