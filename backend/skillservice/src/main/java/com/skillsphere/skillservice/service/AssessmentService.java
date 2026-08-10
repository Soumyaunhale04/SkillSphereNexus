package com.skillsphere.skillservice.service;

import com.skillsphere.skillservice.dto.AssessmentDTO;
import com.skillsphere.skillservice.entity.*;
import com.skillsphere.skillservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    private static final float PASS_THRESHOLD = 70.0f;

    public AssessmentDTO createAssessment(AssessmentDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmpId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        boolean passed = dto.getScore() >= PASS_THRESHOLD;

        Assessment assessment = Assessment.builder()
                .employee(employee)
                .skill(skill)
                .score(dto.getScore())
                .passed(passed)
                .verified(false) // verification is a separate HR action
                .build();

        Assessment saved = assessmentRepository.save(assessment);

        return AssessmentDTO.builder()
                .assessId(saved.getAssessId())
                .empId(employee.getEmpId())
                .skillId(skill.getSkillId())
                .score(saved.getScore())
                .passed(saved.getPassed())
                .verified(saved.getVerified())
                .build();
    }

    public AssessmentDTO verifyAssessment(UUID assessId) {
        Assessment assessment = assessmentRepository.findById(assessId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));

        assessment.setVerified(true);
        assessmentRepository.save(assessment);

        return AssessmentDTO.builder()
                .assessId(assessment.getAssessId())
                .score(assessment.getScore())
                .passed(assessment.getPassed())
                .verified(true)
                .build();
    }
}