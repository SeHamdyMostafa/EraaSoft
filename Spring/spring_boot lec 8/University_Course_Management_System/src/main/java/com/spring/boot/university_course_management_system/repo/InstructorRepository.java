package com.spring.boot.university_course_management_system.repo;

import com.spring.boot.university_course_management_system.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
