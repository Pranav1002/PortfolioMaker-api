package com.project.controllers;

import com.project.exceptions.NotFoundException;
import com.project.models.Experience;
import com.project.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("/{expId}")
    public Experience getExperienceById(@PathVariable Integer expId) {
        return experienceService.getExperienceById(expId)
                .orElseThrow(() -> new NotFoundException("Experience not found with id: " + expId));
    }

    @PutMapping("/{expId}")
    public Experience updateExperience(@PathVariable Integer expId, @RequestBody Experience updatedExperience) {
        return experienceService.updateExperience(expId, updatedExperience);
    }

    @DeleteMapping("/{expId}")
    public void deleteExperience(@PathVariable Integer expId) {
        experienceService.deleteExperience(expId);
    }
}
