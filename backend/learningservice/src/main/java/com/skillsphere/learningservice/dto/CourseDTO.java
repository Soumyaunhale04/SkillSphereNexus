package com.skillsphere.learningservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private java.util.UUID courseId;
    private String title;
    private String description;
    private Integer duration;
    private String type;
    private String instructor;
    private Double rating;
    private Boolean active;
}