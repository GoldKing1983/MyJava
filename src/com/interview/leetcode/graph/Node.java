package com.interview.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
  public final int val;
  public final List<Node> neighbors;

  public Node(final int val, final List<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }

  public Node(final int val) {
    this.val = val;
    this.neighbors = new ArrayList<>();
  }
}
