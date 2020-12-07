package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/longest-univalue-path
 */
public class LongestUnivaluePath {
  int result = 0;

  public int longestUnivaluePath(TreeNode root) {
    if (root != null) dfs(root);
    return result;
  }

  private int dfs(TreeNode node) {
    if (node == null) return 0;

    int left = dfs(node.left);
    int right = dfs(node.right);

    int resultLeft = node.left != null && node.left.val == node.val ? left + 1 : 0;
    int resultRight = node.right != null && node.right.val == node.val ? right + 1 : 0;

    result = Math.max(result, resultLeft + resultRight);
    return Math.max(resultLeft, resultRight);
  }
}
