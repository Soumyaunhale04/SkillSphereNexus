package com.skillsphere.learningservice.repository;

import com.skillsphere.learningservice.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
    List<Enrollment> findByEmpId(UUID empId);
    List<Enrollment> findByCourseCourseId(UUID courseId);
}