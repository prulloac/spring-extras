package com.prulloac.springdata.restquery.nodes.comparison;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;

/** @author Prulloac */
public class DistinctNode extends ComparisonNode {
  public DistinctNode(String field, String[] arguments) {
    super(field, Arrays.asList(arguments));
  }

  @Override
  public Predicate getPredicate(Path<?> propertyPath, CriteriaBuilder criteriaBuilder) {
    List<Object> arguments = getArguments();
    Predicate base =
        criteriaBuilder.notEqual(
            propertyPath, toEnumIfNeeded(propertyPath).apply(arguments.get(0)));
    for (int i = 1; i < arguments.size(); i++) {
      Predicate otherCondition =
          criteriaBuilder.notEqual(
              propertyPath, toEnumIfNeeded(propertyPath).apply(arguments.get(i)));
      base = criteriaBuilder.and(base, otherCondition);
    }
    return base;
  }
}
