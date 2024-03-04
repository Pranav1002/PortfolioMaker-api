package com.project.repositories;

import com.project.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Integer> {

    List<Education> findByUser_UserId(Integer userId);

}
