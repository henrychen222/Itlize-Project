package manage.backendjava.repositories;

import java.util.List;
import manage.backendjava.entities.FormulaEntity;

public interface FormulaRepository extends BaseRepository<FormulaEntity> {

  List<FormulaEntity> findByProjectId(Long projectId);

}
