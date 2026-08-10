package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.CompetencyFramework;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CompetencyFrameworkRepository extends JpaRepository<CompetencyFramework, UUID> {
    List<CompetencyFramework> findByRoleTitle(String roleTitle);
}
