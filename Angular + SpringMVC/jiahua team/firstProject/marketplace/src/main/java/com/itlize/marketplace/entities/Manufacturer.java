package com.itlize.marketplace.entities;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Manufacturer extends BaseEntity {
  private static final long serialVersionUID = 7570301247863094449L;

  private String name;
  private String department;
  private long phone;
  private String email;
  private String web;

}
