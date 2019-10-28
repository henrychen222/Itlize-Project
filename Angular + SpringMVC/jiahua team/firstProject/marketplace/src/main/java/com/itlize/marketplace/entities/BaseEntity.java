package com.itlize.marketplace.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
  private static final long serialVersionUID = -8960301467808000235L;
  private @Id @GeneratedValue long id;

}
