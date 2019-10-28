package com.itlize.marketplace.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseEntity {
  private static final long serialVersionUID = -1814386444128649905L;

  private String firstName;
  private String lastName;
  private String picturePath;

  private @OneToOne(cascade = CascadeType.ALL) UserLogin userLogin;
  private @OneToOne(cascade = CascadeType.ALL) Address address;
}
