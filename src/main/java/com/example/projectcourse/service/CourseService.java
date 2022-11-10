package com.example.projectcourse.service;

import com.example.projectcourse.model.Course;
import com.example.projectcourse.model.Instructor;
import com.example.projectcourse.repository.CourseRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(long id){
        Optional<Course> c=courseRepository.findById(id);
        return c.get();
    }

    public void addCourse(@NotNull Course course){
        LocalDate localDate=LocalDate.now();
        course.setUploadDate(localDate);
        courseRepository.save(course);
    }

    public void updateCourseDate(long id){
        LocalDate localDate=LocalDate.now();
        Course course = this.getCourseById(id);
        course.setUploadDate(localDate);

        courseRepository.save(course);
    }

    public void addInstructor(Instructor instructor, long id){
        Course course= this.getCourseById(id);
        course.setInstructor(instructor);

        courseRepository.save(course);
    }
}
