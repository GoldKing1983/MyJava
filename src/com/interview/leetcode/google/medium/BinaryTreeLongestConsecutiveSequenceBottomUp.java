package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
========================================================Solution Approach========================================================
1) Do post-order traversal. So that we will have left and right of root.
2) from the bottomUp... Check left and right of root... 
3) if there is a sequence... Increment Count.. 
4) else reset count
5) record the maxCount.

 */
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

    //int leftLongestSeq = root.left == null ? 1 : (root.left.val  == root.val + 1) ? left + 1 : 1;
    //int rightLongestSeq = root.right == null ? 1 : (root.right.val  == root.val + 1) ? right + 1 : 1;

    int currentLongestSeq = Math.max(leftLongestSeq, rightLongestSeq);

    maxLongestSequence = Math.max(maxLongestSequence, currentLongestSeq);

    return currentLongestSeq;
  }
}
