package com.spring.boot.university_course_management_system.service;

import com.spring.boot.university_course_management_system.model.Course;
import com.spring.boot.university_course_management_system.model.Student;
import com.spring.boot.university_course_management_system.repo.CourseRepository;
import com.spring.boot.university_course_management_system.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student Not Found"));
    }

    public Student registerCourse(Long studentId, Long courseId){

       Student student = studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student Not Found"));
       Course course= courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course Not Found"));

        student.getCourses().add(course);
        course.getStudents().add(student);

        return studentRepository.save(student);
    }


}
