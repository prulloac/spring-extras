package com.prulloac.springdataextras.specification.nodes.logical;

import com.prulloac.springdataextras.specification.nodes.QueryNode;
import com.prulloac.springdataextras.specification.operators.LogicalOperator;

import java.util.List;

/** @author Prulloac */
public class OrNode extends LogicalNode {
  public OrNode(List<? extends QueryNode> children) {
    super(children);
  }

  @Override
  public LogicalOperator getOperator() {
    return LogicalOperator.OR;
  }
}
