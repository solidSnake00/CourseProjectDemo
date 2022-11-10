package com.example.projectcourse.service;

import com.example.projectcourse.model.Course;
import com.example.projectcourse.model.Instructor;
import com.example.projectcourse.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(long id){
        Optional<Instructor> i=instructorRepository.findById(id);
        return i.get();
    }

    public void addInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public List<Course> getInstructorCourses(long id){
        Instructor instructor=this.getInstructorById(id);
        return instructor.getCourses();
    }

    public static class PlanService {
    }
}
