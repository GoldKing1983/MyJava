package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

public class SumOfLeftLeavesBottomUp { 

  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, false);
  }

  public int sumOfLeftLeaves(TreeNode root, boolean leftTrue) {

    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null && leftTrue) {
      return root.val;
    }
    int left = sumOfLeftLeaves(root.left, true);
    int right = sumOfLeftLeaves(root.right, false);
    return left + right;
  }
}
