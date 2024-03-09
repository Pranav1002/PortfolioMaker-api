package com.project.services;

import com.project.models.Project;
import com.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getEducationByUserId(Integer userId) {
        return projectRepository.findByUser_UserId(userId);
    }
    public Optional<Project> getProjectById(Integer projectId) {
        return projectRepository.findById(projectId);
    }

    public void deleteProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }

    public Project updateProject(Integer projectId, Project updatedProject) {
        if (projectRepository.existsById(projectId)) {
            updatedProject.setProjectId(projectId);
            return projectRepository.save(updatedProject);
        }
        return null;
    }
}
