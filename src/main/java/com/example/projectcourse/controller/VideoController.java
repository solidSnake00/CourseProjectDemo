package com.example.projectcourse.controller;

import com.example.projectcourse.model.Course;
import com.example.projectcourse.model.Video;
import com.example.projectcourse.service.CourseService;
import com.example.projectcourse.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {
    @Autowired
    public final VideoService videoService;
    @Autowired
    public final CourseService courseService;

    public VideoController(VideoService videoService, CourseService courseService) {
        this.videoService = videoService;
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public List<Video> displayAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("/id/{id}")
    public Video displayVideo(@PathVariable long id){
        return videoService.getVideoById(id);
    }

    @PostMapping("/create")
    public void createVideo(@RequestBody @Valid Video video,@RequestBody long id){
        Course course=courseService.getCourseById(id);
        video.setCourse(course);
        videoService.addVideo(video);
    }

    @DeleteMapping("/delete")
    public void deleteVideo(@RequestBody long id){
        videoService.deleteVideo(id);
    }
}