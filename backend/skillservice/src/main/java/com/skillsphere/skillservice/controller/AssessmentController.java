package com.skillsphere.skillservice.controller;

import com.skillsphere.skillservice.dto.AssessmentDTO;
import com.skillsphere.skillservice.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PostMapping
    public AssessmentDTO createAssessment(@RequestBody AssessmentDTO dto) {
        return assessmentService.createAssessment(dto);
    }

    @PutMapping("/{id}/verify")
    @PreAuthorize("hasRole('HR')")
    public AssessmentDTO verifyAssessment(@PathVariable UUID id) {
        return assessmentService.verifyAssessment(id);
    }
}