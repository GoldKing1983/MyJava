package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversalBest {
  List<Integer> result = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return result;
    result.add(root.val);
    preorderTraversal(root.left);
    return preorderTraversal(root.right);
  }
}
