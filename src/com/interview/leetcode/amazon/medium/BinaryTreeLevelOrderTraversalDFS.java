package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * ======================================Solution Approach======================================
 * 
 * DFS is best and faster.
 *
 */
public class BinaryTreeLevelOrderTraversalDFS {
  public List<List<Integer>> levelOrderDFS(TreeNode root) {
    return levelOrder(root, 0, new ArrayList<>());
  }

  private List<List<Integer>> levelOrder(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return result;
    if (result.size() == level) result.add(new ArrayList<>());
    result.get(level).add(root.val);
    levelOrder(root.left, level + 1, result);
    return levelOrder(root.right, level + 1, result);
  }
}
