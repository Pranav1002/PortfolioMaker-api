package com.project.repositories;

import com.project.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer> {
}
