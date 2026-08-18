package com.skillsphere.learningservice.controller;

import com.skillsphere.learningservice.entity.CourseContent;
import com.skillsphere.learningservice.service.CourseContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/learning/content")
@RequiredArgsConstructor
public class CourseContentController {
    private final CourseContentService contentService;
    @PostMapping("/course/{courseId}")
    public CourseContent addContent(
            @PathVariable UUID courseId,
            @RequestBody CourseContent content) {
        return contentService.addContent(courseId, content);
    }
    @GetMapping("/course/{courseId}")
    public List<CourseContent> getContent(
            @PathVariable UUID courseId) {
        return contentService.getCourseContent(courseId);
    }
}
