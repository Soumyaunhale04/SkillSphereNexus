package com.skillsphere.skillservice.dto;

import lombok.*;
import java.util.UUID;

@Data @Builder
public class AssessmentDTO {
    private UUID assessId;
    private UUID empId;
    private UUID skillId;
    private Float score;
    private Boolean passed;
    private Boolean verified;
}