package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/closest-binary-search-tree-value/description/
============================================================Requirement==================================================================
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
============================================================Solution Approach============================================================
1) Calculate closestValue for every node based on currentDifference.
2) Then decide go left or right --> if (target < root.val) go left, else go right.

Note: Root is guaranteed to be not null or there will be only one unique value in the BST that is closest to the target.
=========================================================================================================================================
*/

public class ClosestBinarySearchTreeValueIterative {

  public int closestValue(TreeNode root, double target) {
    int closestValue = Integer.MAX_VALUE;
    double minDifference = Double.MAX_VALUE;
    while (root != null) {
      double currentDifference = Math.abs(root.val - target);
      if (currentDifference < minDifference) {
        closestValue = root.val;
        minDifference = currentDifference;
      }
      if (target < root.val) root = root.left;
      else if (target > root.val) root = root.right;
      else return closestValue; // return instantly if target and root.val matches  
    }
    return closestValue;
  }
}
