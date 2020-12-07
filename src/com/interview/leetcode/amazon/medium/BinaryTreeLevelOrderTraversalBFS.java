package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
 https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversalBFS {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> levelResult = new ArrayList<>();
      while (size-- > 0) {
        TreeNode curr = q.poll();
        levelResult.add(curr.val);
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }
      result.add(levelResult);
    }
    return result;
  }
}
