package com.example.teachers.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true,updatable = false)
    private String email;
    @Column(nullable = false)
    private String degree;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return email.equals(teacher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
