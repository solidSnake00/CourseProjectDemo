package com.example.projectcourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "course_type")
    private int type;
    @Column(name = "upload_date")
    private LocalDate uploadDate;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "course")
    @JsonIgnore
    private List<Video> videoList;//Done

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


}
