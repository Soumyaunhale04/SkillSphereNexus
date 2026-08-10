package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {
    List<Certification> findByEmployeeEmpId(UUID empId);
}