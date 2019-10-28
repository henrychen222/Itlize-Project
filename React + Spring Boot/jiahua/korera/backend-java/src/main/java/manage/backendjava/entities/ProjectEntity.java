package manage.backendjava.entities;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectEntity extends BaseEntity {
  private static final long serialVersionUID = -8849876441733701874L;

  private Long projectId;

  private String name;
  private String cost_code;
  private @OneToOne ResourceEntity resource;

  private @ElementCollection Map<String, String> survey_fields;

}
