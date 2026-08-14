package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.LearningPathCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LearningPathCourseRepository
        extends JpaRepository<LearningPathCourse, UUID> {
    List<LearningPathCourse> findByLearningPathPathIdOrderBySequenceOrder(UUID pathId);
}
