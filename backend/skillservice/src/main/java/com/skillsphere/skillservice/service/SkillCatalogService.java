package com.skillsphere.skillservice.service;

import com.skillsphere.skillservice.dto.SkillDTO;
import com.skillsphere.skillservice.entity.Skill;
import com.skillsphere.skillservice.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillCatalogService {

    private final SkillRepository skillRepository;

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public SkillDTO addSkill(SkillDTO dto) {
        Skill skill = Skill.builder()
                .name(dto.getName())
                .category(Skill.Category.valueOf(dto.getCategory()))
                .build();
        return toDTO(skillRepository.save(skill));
    }

    private SkillDTO toDTO(Skill skill) {
        return SkillDTO.builder()
                .skillId(skill.getSkillId())
                .name(skill.getName())
                .category(skill.getCategory().name())
                .build();
    }
}