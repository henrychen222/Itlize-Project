package manage.backendjava.entities;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceEntity extends BaseEntity {
  private static final long serialVersionUID = -1599329942028449833L;

  private String name;
  private String cost_code;

  private @ElementCollection Map<String, String> data;

}
