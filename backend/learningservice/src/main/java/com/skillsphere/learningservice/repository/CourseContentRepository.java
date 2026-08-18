package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseContentRepository extends JpaRepository<CourseContent, UUID> {
    List<CourseContent> findByCourseCourseIdOrderBySequenceOrder(UUID courseId);
}