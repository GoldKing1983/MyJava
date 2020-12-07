package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceBottomUp {

  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    recur(root);
    return maxLongestSequence;
  }

  int maxLongestSequence = Integer.MIN_VALUE;

  // BottomUp cannot be done without returning value logically. So void not possible
  private int recur(TreeNode root) {
    if (root == null) return 0;
    int left = recur(root.left);
    int right = recur(root.right);
    int leftLongestSeq = (root.left != null && root.left.val + 1 == root.val) ? left + 1 : 1;
    int rightLongestSeq = (root.right != null && root.right.val + 1 == root.val) ? right + 1 : 1;
    int currentLongestSeq = Math.max(leftLongestSeq, rightLongestSeq);
    maxLongestSequence = Math.max(maxLongestSequence, currentLongestSeq);
    return currentLongestSeq;
  }
}
