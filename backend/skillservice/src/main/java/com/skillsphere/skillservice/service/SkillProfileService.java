package com.skillsphere.skillservice.service;

import com.skillsphere.skillservice.entity.*;
import com.skillsphere.skillservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SkillProfileService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeSkillRepository employeeSkillRepository;
    private final AssessmentRepository assessmentRepository;
    private final CertificationRepository certificationRepository;

    @Cacheable(value = "skillProfiles", key = "#empId")
    public Object getSkillProfile(UUID empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + empId));

        List<EmployeeSkill> skills = employeeSkillRepository.findByEmployeeEmpId(empId);
        List<Certification> certs = certificationRepository.findByEmployeeEmpId(empId);
        List<Assessment> assessments = assessmentRepository.findByEmployeeEmpId(empId);

        return java.util.Map.of(
                "employee", employee,
                "skills", skills,
                "certifications", certs,
                "assessments", assessments
        );
    }
}