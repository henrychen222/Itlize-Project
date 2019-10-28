package com.itlize.marketplace.entities;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends BaseEntity {
  private static final long serialVersionUID = 817979112435251527L;

  private String category;
  private String subCategory;
  private LocalDate verified;
  private String imgUrl;

  // Product Summary
  private @ElementCollection Map<String, String> description;
  private @ElementCollection Map<String, String> type$;
  private @ElementCollection Map<String, String> technical_specifications$;

  // Product Details
  private @ElementCollection Set<String> series_information;

  // Contact
  private @ElementCollection Map<String, String> sales_representative;
  private @ElementCollection Map<String, String> manufacturer;

  // Past Selections
  private @ElementCollection Map<String, String> past_selections$;
}
