package com.skillsphere.skillservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "employee_skills")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeSkill {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    private Integer proficiency;
}
