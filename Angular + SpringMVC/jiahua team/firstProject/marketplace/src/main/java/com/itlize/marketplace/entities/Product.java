package com.itlize.marketplace.entities;

import java.util.Date;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {
  private static final long serialVersionUID = 7166132837560350109L;

  private String series;
  private String model;

  private String useType;
  private String application;
  private String mountingLocation;
  private String accessories;
  private int modelYear;

  private String category;
  private String subCategory;
  private String picturePath;

  // private String name; manufacturer.name + series + model
  private Date verified;
  // private String pastSpecifications; // ignored
  private String details;

  private @ElementCollection Map<String, String> data;
  private @ElementCollection Map<String, Integer> dataInt;
  private @ElementCollection Map<String, Double> dataDouble;

  private @OneToOne(cascade = CascadeType.ALL) Manufacturer manufacturer;
  private @OneToOne(cascade = CascadeType.ALL) SalesRepresentative salesRepresentative;

}
