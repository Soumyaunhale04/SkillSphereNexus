package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}