package com.skillsphere.skillservice.dto;

import lombok.*;

@Data @Builder
public class CompetencyGapDTO {
    private String skillName;
    private Integer currentProficiency;
    private Integer requiredProficiency;
    private Integer gap; // negative if below target, e.g. -3 = "Gaps: Angular +3"
}