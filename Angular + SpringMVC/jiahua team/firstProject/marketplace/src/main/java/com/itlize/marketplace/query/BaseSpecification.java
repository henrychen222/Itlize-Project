package com.itlize.marketplace.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseSpecification<T> implements Specification<T> {
  private static final long serialVersionUID = 1L;

  private SearchCriteria searchCriteria;

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {
    String key = searchCriteria.getKey();
    Expression<String> expression = root.get(key);
    String value = searchCriteria.getValue().toString();
    switch (searchCriteria.getOperation()) {
      case ">":
        return criteriaBuilder.greaterThan(expression, value);
      case "<":
        return criteriaBuilder.lessThan(expression, value);
      case ">=":
        return criteriaBuilder.greaterThanOrEqualTo(expression, value);
      case "<=":
        return criteriaBuilder.lessThanOrEqualTo(expression, value);
      case "=":
        return criteriaBuilder.equal(expression, value);
      case ":":
        return criteriaBuilder.like(expression, value);
      case "~":
        return criteriaBuilder.like(criteriaBuilder.trim(criteriaBuilder.lower(expression)),
            value.toLowerCase().trim());
      case "%":
        return criteriaBuilder.like(expression, "%" + value + "%");
      case "*":
        return criteriaBuilder.like(criteriaBuilder.trim(criteriaBuilder.lower(expression)),
            "%" + value.toLowerCase().trim() + "%");
      default:
        return null;
    }
  }

}
