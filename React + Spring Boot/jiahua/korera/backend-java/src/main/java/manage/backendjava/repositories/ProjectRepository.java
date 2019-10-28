package manage.backendjava.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import manage.backendjava.entities.ProjectEntity;

public interface ProjectRepository extends BaseRepository<ProjectEntity> {

  @Query("SELECT DISTINCT projectId FROM ProjectEntity")
  List<String> getDistinctProjectIds();

  List<ProjectEntity> findByProjectId(Long projectId);

}
