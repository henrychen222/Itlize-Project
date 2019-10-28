package manage.backendjava.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import manage.backendjava.security.Role;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {
  private static final long serialVersionUID = 1L;

  private @Column(unique = true, nullable = false) String username;
  private String password;
  private Date joined;

  private @ElementCollection(fetch = FetchType.EAGER) List<Role> roles;
  private String salt;

}
