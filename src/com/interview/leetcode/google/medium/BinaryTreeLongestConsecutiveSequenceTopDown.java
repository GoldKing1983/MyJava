package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceTopDown {
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    recur(root, 1);
    return maxLongestSequence;
  }

  int maxLongestSequence = 0;

  private void recur(TreeNode root, int currentLongestSeq) {
    maxLongestSequence = Math.max(maxLongestSequence, currentLongestSeq);
    if (root == null) return;
    if (root.left != null) {
      if (root.left.val == root.val + 1) {
        recur(root.left, currentLongestSeq + 1);
      } else {
        recur(root.left, 1);
      }
    }
    if (root.right != null) {
      if (root.right.val == root.val + 1) {
        recur(root.right, currentLongestSeq + 1);
      } else {
        recur(root.right, 1);
      }
    }
  }
}
