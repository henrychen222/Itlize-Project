package com.itlize.marketplace.controllers;

import com.itlize.marketplace.entities.Project;
import com.itlize.marketplace.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController extends GenericRestController<Project> {

  @Autowired
  ProjectRepository repository;

  @GetMapping("/add")
  Project add() {
    Project project = new Project();
    project.setAddress("project address random where");
    project.setClientName("clientName for this project");
    project.setName("Project thy name is");
    project.setProductsList("random list apple banana cat dough");
    project.setQuote(123.456);
    project.setSize("large random size");
    project.setType("random luck type");
    return repository.save(project);
  }

}
