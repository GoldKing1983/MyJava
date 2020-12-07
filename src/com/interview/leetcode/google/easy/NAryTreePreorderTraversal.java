package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.Node;

/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class NAryTreePreorderTraversal {
  List<Integer> result = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    if (root == null) return result;
    result.add(root.val);
    for (Node child : root.children) {
      preorder(child);
    }
    return result;
  }
}
