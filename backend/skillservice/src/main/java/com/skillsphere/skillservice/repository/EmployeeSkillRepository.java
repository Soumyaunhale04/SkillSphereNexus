package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, UUID> {
    List<EmployeeSkill> findByEmployeeEmpId(UUID empId);
}