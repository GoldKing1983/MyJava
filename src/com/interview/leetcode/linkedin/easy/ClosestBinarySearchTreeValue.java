package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/closest-binary-search-tree-value/description/
============================================================Requirement=================================================================
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
============================================================Solution Approach============================================================
1) Calculate closestValue for every node based on currentDifference.
2) Then decide go left or right --> if (target < root.val) go left, else go right.

Note: Root is guaranteed to be not null or there will be only one unique value in the BST that is closest to the target.
=========================================================================================================================================
*/

public class ClosestBinarySearchTreeValue {

  public int closestValue(TreeNode root, double target) {
    return closest(root, target, root.val);
  }

  private int closest(TreeNode node, double target, int currentCloseValue) {
    if (node == null) return currentCloseValue;
    if (Math.abs(node.val - target) < Math.abs(currentCloseValue - target)) {
      currentCloseValue = node.val;
    }
    if (target < node.val) return closest(node.left, target, currentCloseValue);
    if (target > node.val) return closest(node.right, target, currentCloseValue);
    return currentCloseValue;
  }
}
