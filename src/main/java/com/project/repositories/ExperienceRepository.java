package com.project.repositories;

import com.project.models.Education;
import com.project.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    List<Experience> findByUser_UserId(Integer userId);
//    List<Education> findByUser_UserId(Integer userId);
}
