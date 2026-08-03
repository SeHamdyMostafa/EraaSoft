package com.spring.boot.university_course_management_system.service;

import com.spring.boot.university_course_management_system.model.Course;
import com.spring.boot.university_course_management_system.model.Instructor;
import com.spring.boot.university_course_management_system.repo.CourseRepository;
import com.spring.boot.university_course_management_system.repo.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course assignInstructor(Long courseId, Long instructorId) {

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("Instructor not found"));

        course.setInstructor(instructor);
        instructor.getCourses().add(course);

        return courseRepository.save(course);
    }

    
}
