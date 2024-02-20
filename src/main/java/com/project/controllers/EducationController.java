package com.project.controllers;

import com.project.exceptions.NotFoundException;
import com.project.models.Education;
import com.project.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @GetMapping
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{eduId}")
    public Education getEducationById(@PathVariable Integer eduId) {
        return educationService.getEducationById(eduId)
                .orElseThrow(() -> new NotFoundException("Education not found with id: " + eduId));
    }

    @PutMapping("/{eduId}")
    public Education updateEducation(@PathVariable Integer eduId, @RequestBody Education updatedEducation) {
        return educationService.updateEducation(eduId, updatedEducation);
    }

    @DeleteMapping("/{eduId}")
    public void deleteEducation(@PathVariable Integer eduId) {
        educationService.deleteEducation(eduId);
    }
}

