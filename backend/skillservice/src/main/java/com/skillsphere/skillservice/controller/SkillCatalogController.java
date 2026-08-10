package com.skillsphere.skillservice.controller;

import com.skillsphere.skillservice.dto.SkillDTO;
import com.skillsphere.skillservice.service.SkillCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills/catalog")
@RequiredArgsConstructor
public class SkillCatalogController {

    private final SkillCatalogService skillCatalogService;

    @GetMapping
    public List<SkillDTO> getCatalog() {
        return skillCatalogService.getAllSkills();
    }

    @PostMapping
    @PreAuthorize("hasRole('HR')")
    public SkillDTO addSkill(@RequestBody SkillDTO dto) {
        return skillCatalogService.addSkill(dto);
    }
}