package com.skillsphere.skillservice.dto;

import lombok.*;
import java.util.UUID;

@Data @Builder
public class SkillDTO {
    private UUID skillId;
    private String name;
    private String category;
}
