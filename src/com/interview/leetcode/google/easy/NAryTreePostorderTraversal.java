package com.interview.leetcode.google.easy;

import com.interview.leetcode.Node;
import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class NAryTreePostorderTraversal {
  public List<Integer> preorderDFS(Node root) {
    List<Integer> result = new ArrayList<>();
    recur(root, result);
    return result;
  }

  private void recur(Node root, List<Integer> result) {
    if (root == null) return;
    for (Node child : root.children) {
      recur(child, result);
    }
    result.add(root.val);
  }
}
