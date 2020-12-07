package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;
/*



*/
public class SplitBSTAlternate {

  public TreeNode[] recur(TreeNode root, int target) {
    if (root == null) return new TreeNode[2];
    if (root.val > target) {
      TreeNode[] splitNode = recur(root.left, target);
      root.left = splitNode[0];
      return new TreeNode[] {root, splitNode[1]};
    }
    TreeNode[] splitNode = recur(root.right, target);
    root.right = splitNode[1];
    return new TreeNode[] {splitNode[0], root};
  }

  public TreeNode[] splitBST(TreeNode root, int V) {
    TreeNode[] result = recur(root, V);
    return new TreeNode[] {result[1], result[0]}; // answer will be reversed in recur.
  }
}
