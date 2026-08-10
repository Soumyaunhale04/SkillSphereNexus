package com.skillsphere.skillservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "assessments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Assessment {

    @Id
    @GeneratedValue
    private UUID assessId;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    private Float score;
    private Boolean passed;
    private Boolean verified;
}
