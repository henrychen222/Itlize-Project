package com.itlize.marketplace.entities;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Categories extends BaseEntity {
  private static final long serialVersionUID = -3626246534716766161L;

  private String category;
  private String subCategory;

  private @ElementCollection Map<String, String> attributes;
}
