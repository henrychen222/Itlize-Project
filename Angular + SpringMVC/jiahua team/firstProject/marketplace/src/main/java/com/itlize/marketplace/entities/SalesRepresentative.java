package com.itlize.marketplace.entities;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class SalesRepresentative extends BaseEntity {
  private static final long serialVersionUID = -2396638842433547971L;

  private String name;
  private long phone;
  private String email;
  private String web;
}
