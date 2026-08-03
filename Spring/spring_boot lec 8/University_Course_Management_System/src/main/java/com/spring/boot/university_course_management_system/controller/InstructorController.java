package com.spring.boot.university_course_management_system.controller;

import com.spring.boot.university_course_management_system.model.Course;
import com.spring.boot.university_course_management_system.model.Instructor;
import com.spring.boot.university_course_management_system.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    //  http://localhost:8082/api/instructors
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.CreateInstructor(instructor);
    }

    //  http://localhost:8082/api/instructors
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.GetAllInstructors();
    }

    //  http://localhost:8082/api/instructors/5/courses
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByInstructor(@PathVariable Long id) {
        return instructorService.getCoursesByInstructor(id);
    }
}
