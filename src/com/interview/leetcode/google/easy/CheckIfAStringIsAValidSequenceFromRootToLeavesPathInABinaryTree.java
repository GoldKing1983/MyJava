package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

/*
Given a binary tree where each path going from the root to any leaf form a valid sequence,
check if a given string is a valid sequence in such binary tree.

We get the given string from the concatenation of an array of integers arr and the concatenation
of all values of the nodes along a path results in a sequence in the given binary tree.


 */
public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

  public boolean isValidSequence(TreeNode root, int[] arr) {
    return recur(root, arr, 0, arr.length);
  }

  private boolean recur(TreeNode root, int[] arr, int level, int n) {
    if (root == null) return false;
    if (arr[level] != root.val) return false;
    // Ex: arr=[1], root=[1], level =0, n=1,
    if (level == n - 1) return root.left == null && root.right == null;

    boolean left = recur(root.left, arr, level + 1, n);
    boolean right = recur(root.right, arr, level + 1, n);

    return left || right;
  }
}
