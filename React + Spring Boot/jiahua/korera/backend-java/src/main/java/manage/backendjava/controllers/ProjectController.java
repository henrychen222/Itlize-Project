package manage.backendjava.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import manage.backendjava.entities.ProjectEntity;
import manage.backendjava.repositories.ProjectRepository;

@RestController
@RequestMapping("project")
public class ProjectController extends BaseController<ProjectEntity> {

  @Autowired
  ProjectRepository projectRepository;

  @GetMapping("/getProjectIds")
  List<String> getProjectIds() {
    return projectRepository.getDistinctProjectIds();
  }

  @GetMapping("/projectId/{id}")
  List<ProjectEntity> getByProjectId(@PathVariable Long id) {
    return projectRepository.findByProjectId(id);
  }

  @PostMapping("/delete/batch")
  void batchDelete(@RequestBody List<ProjectEntity> entities) {
    projectRepository.deleteAll(entities);
  }

}
