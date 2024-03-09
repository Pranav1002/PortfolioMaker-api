package com.project.services;

import com.project.models.Education;
import com.project.models.Experience;
import com.project.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

//    public List<Experience> getEducationByUserId(Integer userId) {
//        return experienceRepository.findByUser_UserId(userId);
//    }
public List<Experience> getEducationByUserId(Integer userId) {
    return experienceRepository.findByUser_UserId(userId);
}

    public Optional<Experience> getExperienceById(Integer expId) {
        return experienceRepository.findById(expId);
    }

    public void deleteExperience(Integer expId) {
        experienceRepository.deleteById(expId);
    }

    public Experience updateExperience(Integer expId, Experience updatedExperience) {
        if (experienceRepository.existsById(expId)) {
            updatedExperience.setExpId(expId);
            return experienceRepository.save(updatedExperience);
        }
        return null;
    }
}

