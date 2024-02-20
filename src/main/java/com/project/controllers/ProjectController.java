package com.project.controllers;

import com.project.exceptions.NotFoundException;
import com.project.models.Project;
import com.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable Integer projectId) {
        return projectService.getProjectById(projectId)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + projectId));
    }

    @PutMapping("/{projectId}")
    public Project updateProject(@PathVariable Integer projectId, @RequestBody Project updatedProject) {
        return projectService.updateProject(projectId, updatedProject);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Integer projectId) {
        projectService.deleteProject(projectId);
    }
}

