package com.project.services;

import com.project.models.Education;
import com.project.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public List<Education> getEducationByUserId(Integer userId) {
        return educationRepository.findByUser_UserId(userId);
    }

    public Optional<Education> getEducationById(Integer eduId) {
        return educationRepository.findById(eduId);
    }

    public void deleteEducation(Integer eduId) {
        educationRepository.deleteById(eduId);
    }

    public Education updateEducation(Integer eduId, Education updatedEducation) {
        if (educationRepository.existsById(eduId)) {
            updatedEducation.setEduId(eduId);
            return educationRepository.save(updatedEducation);
        }
        return null;
    }
}

