package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

public class SumOfLeftLeavesTopDown {

  public int sumOfLeftLeaves(TreeNode root) {
    recur(root, false);
    return sum;
  }

  int sum = 0;

  private void recur(TreeNode root, boolean isLeft) {
    if (root == null) return;

    if (isLeft && root.left == null && root.right == null) {
      sum += root.val;
      return;
    }

    recur(root.left, true);

    recur(root.right, false);
  }
}
