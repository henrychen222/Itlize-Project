package com.itlize.marketplace.entities;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Project extends BaseEntity {
  private static final long serialVersionUID = -8484632514141745360L;

  private String name;
  private String address;
  private String type;
  private String size;
  private String clientName;
  private String productsList;
  private double quote;

}
