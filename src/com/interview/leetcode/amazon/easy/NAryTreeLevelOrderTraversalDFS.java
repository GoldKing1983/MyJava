package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.Node;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversalDFS {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderDFS(root, 0, result);
    return result;
  }

  // This method runs faster, as it doesn't need additional Data Structure
  private void levelOrderDFS(Node node, int level, List<List<Integer>> result) {
    if (node == null) return;
    if (result.size() == level) result.add(new ArrayList<>());
    result.get(level).add(node.val);
    for (Node children : node.children) levelOrderDFS(children, level + 1, result);
  }
}
