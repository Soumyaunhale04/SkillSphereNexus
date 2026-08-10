package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
}
