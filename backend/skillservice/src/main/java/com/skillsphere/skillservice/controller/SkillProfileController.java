package com.skillsphere.skillservice.controller;

import com.skillsphere.skillservice.service.SkillProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillProfileController {

    private final SkillProfileService skillProfileService;

    @GetMapping("/employee/{empId}")
    public Object getProfile(@PathVariable UUID empId) {
        return skillProfileService.getSkillProfile(empId);
    }
}
