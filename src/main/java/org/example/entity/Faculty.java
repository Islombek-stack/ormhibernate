package org.example.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String code;
    private String dean;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)

    @OneToMany(mappedBy = "faculty",  cascade = CascadeType.ALL)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "faculty")
    private List<Student> students = new ArrayList<>();

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "updated_up")
    public LocalDateTime updatedUp;

    public Faculty(LocalDateTime createdAt, LocalDateTime updatedUp) {
        this.createdAt = createdAt;
        this.updatedUp = updatedUp;
    }


    public void setUniversity(Object o) {
    }
}
