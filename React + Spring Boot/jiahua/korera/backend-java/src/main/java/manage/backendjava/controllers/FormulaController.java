package manage.backendjava.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import manage.backendjava.entities.FormulaEntity;
import manage.backendjava.repositories.FormulaRepository;

@RequestMapping("formula")
@RestController
public class FormulaController extends BaseController<FormulaEntity> {

  @Autowired
  FormulaRepository formulaRepository;

  @GetMapping("/projectId/{id}")
  FormulaEntity getByProjectId(@PathVariable Long id) {

    List<FormulaEntity> results = formulaRepository.findByProjectId(id);
    if (results.isEmpty()) {
      FormulaEntity formulaEntity = new FormulaEntity();
      formulaEntity.setProjectId(id);

      Map<String, Boolean> scope = new HashMap<>();
      scope.put("name", true);
      scope.put("cost_code", true);
      formulaEntity.setScope(scope);

      return formulaRepository.save(formulaEntity);
    } else {
      return results.get(0);
    }
  }

}
