package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.LearningCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearningCertificateRepository extends JpaRepository<LearningCertificate, UUID> {
}
