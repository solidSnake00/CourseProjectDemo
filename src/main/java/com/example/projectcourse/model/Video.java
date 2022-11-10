package com.example.projectcourse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional= false )
    @JoinColumn(name="course_id", nullable = false)
    private Course course;//Done
}
