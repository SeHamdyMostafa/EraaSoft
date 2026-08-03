package com.spring.boot.university_course_management_system.service;

import com.spring.boot.university_course_management_system.model.Course;
import com.spring.boot.university_course_management_system.model.Instructor;
import com.spring.boot.university_course_management_system.repo.CourseRepository;
import com.spring.boot.university_course_management_system.repo.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor CreateInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }
    public List<Instructor> GetAllInstructors(){
        return instructorRepository.findAll();
    }

    public List<Course> getCoursesByInstructor(Long InstructorId ){
        Instructor instructor=instructorRepository.findById(InstructorId).orElseThrow(()-> new RuntimeException("Instructor Not Found"));
        return instructor.getCourses();
    }



}
