package com.spring.boot.university_course_management_system.controller;

import com.spring.boot.university_course_management_system.model.Course;
import com.spring.boot.university_course_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // http://localhost:8082/api/courses
    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    // http://localhost:8082/api/courses
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    // http://localhost:8082/api/courses/5/instructor/1
    @PutMapping("/{courseId}/instructor/{instructorId}")
    public Course assignInstructor(@PathVariable Long courseId,
                                   @PathVariable Long instructorId) {

        return courseService.assignInstructor(courseId, instructorId);
    }


}
