package com.skillsphere.skillservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "competency_frameworks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CompetencyFramework {

    @Id
    @GeneratedValue
    private UUID id;

    private String roleTitle; // e.g. "Tech Lead"

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Integer requiredProficiency; // target level for this role
}