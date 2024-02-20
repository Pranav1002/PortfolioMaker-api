package com.project.repositories;

import com.project.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
