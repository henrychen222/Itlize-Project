package com.itlize.marketplace.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserLogin extends BaseEntity {
  private static final long serialVersionUID = -3884274518765830165L;

  private @Column(unique = true) String email;
  private @Column(unique = true) String username;
  private String password;
  private String salt;

}
