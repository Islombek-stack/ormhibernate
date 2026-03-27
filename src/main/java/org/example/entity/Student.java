package org.example.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity                     //govorim hibernate chto eto tablitsa
@Table(name = "students")    // imya tablitsi (opsionalno)
public class Student {
    @Id                  //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Autoincrement
    @Column(name = "id")              //Column with name id
    private Long id;

    @Column (name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "age")
    private Integer age ;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Transient      //ne soxranyayetsa b DB
    private String temporaryData;

    public University getUniversity() {
        return university;
    }


    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    public Student() {
    }

    public Student(Long id, String name, Integer age, String email, LocalDateTime created_at, String temporaryData) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.created_at = created_at;
        this.temporaryData = temporaryData;
    }
    public void setUniversity(University university) {
        this.university = university;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public String getTemporaryData() {
        return temporaryData;
    }
    public void setTemporaryData(String temporaryData) {
        this.temporaryData = temporaryData;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", created_at=" + created_at +
                ", temporaryData='" + temporaryData + '\'' +
                '}';
    }

    public void setUniversity(Object o) {
    }
}
