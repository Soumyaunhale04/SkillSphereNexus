package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.LearningPath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearningPathRepository extends JpaRepository<LearningPath, UUID> {
}
