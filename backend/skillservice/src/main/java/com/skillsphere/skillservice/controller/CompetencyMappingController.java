package com.skillsphere.skillservice.controller;

import com.skillsphere.skillservice.dto.CompetencyGapDTO;
import com.skillsphere.skillservice.service.CompetencyMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/competency")
@RequiredArgsConstructor
public class CompetencyMappingController {

    private final CompetencyMappingService competencyMappingService;

    @GetMapping("/gaps")
    public List<CompetencyGapDTO> getGaps(@RequestParam UUID empId, @RequestParam String targetRole) {
        return competencyMappingService.getGapsForRole(empId, targetRole);
    }
}