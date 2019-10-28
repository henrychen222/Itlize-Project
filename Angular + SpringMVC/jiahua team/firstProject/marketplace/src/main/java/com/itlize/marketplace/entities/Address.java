package com.itlize.marketplace.entities;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends BaseEntity {
  private static final long serialVersionUID = 4189623209235073069L;

  private String addrLine1;
  private String addrLine2;
  private String city;
  private int zip;
  private String state;
  // private String region;
  private String country;
}
