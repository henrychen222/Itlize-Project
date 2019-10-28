package manage.backendjava.entities;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class FormulaEntity extends BaseEntity {
  private static final long serialVersionUID = -4071880284720290255L;

  private @Column(unique = true) Long projectId;

  private @ElementCollection Map<String, Boolean> scope;
  private @ElementCollection Map<String, String> survey;

}
