package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<Assessment, UUID> {
    List<Assessment> findByEmployeeEmpId(UUID empId);
}