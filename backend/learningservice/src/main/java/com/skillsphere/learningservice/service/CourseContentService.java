package com.skillsphere.learningservice.service;

import com.skillsphere.learningservice.entity.Course;
import com.skillsphere.learningservice.entity.CourseContent;
import com.skillsphere.learningservice.repository.CourseContentRepository;
import com.skillsphere.learningservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseContentService {
    private final CourseContentRepository contentRepository;
    private final CourseRepository courseRepository;
    public CourseContent addContent(UUID courseId, CourseContent content) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));
        content.setCourse(course);
        return contentRepository.save(content);
    }
    public List<CourseContent>
    getCourseContent(UUID courseId) {
        return contentRepository
                .findByCourseCourseIdOrderBySequenceOrder(courseId);
    }
}
