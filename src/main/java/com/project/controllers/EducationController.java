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

    @GetMapping("/get/{userId}")
    public List<Education> getEducationsByUserId(@PathVariable Integer userId) {
        return educationService.getEducationsByUserId(userId);
    }

    @PutMapping("/update/{eduId}")
    public Education updateEducation(@PathVariable Integer eduId, @RequestBody Education updatedEducation) {
        return educationService.updateEducation(eduId, updatedEducation);
    }

    @DeleteMapping("/delete/{eduId}")
    public void deleteEducation(@PathVariable Integer eduId) {
        educationService.deleteEducation(eduId);
    }
}

