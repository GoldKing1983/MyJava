package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/closest-binary-search-tree-value/description/
===========================================================Requirement===========================================================
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
========================================================Solution Approach========================================================
1) Calculate closestValue for every node based on currentDifference.
2) Then decide go left or right --> if (target < root.val) go left, else go right.

Note: Root is guaranteed to be not null or there will be only one unique value in the BST that is closest to the target.
=======================================================Data Flow Analysis========================================================
                           4
                         /   \
                        2     5
                       / \ 
                      1   3
target=2.50001
closestValue : 4, closestDifference :1.49999
closestValue : 4, closestDifference :1.49999
closestValue : 2, closestDifference :0.5000100000000001
closestValue : 3, closestDifference :0.49998999999999993

target=2.49
closestValue : 4, closestDifference :1.5099999999999998
closestValue : 4, closestDifference :1.5099999999999998
closestValue : 2, closestDifference :0.4900000000000002
closestValue : 2, closestDifference :0.4900000000000002
=================================================================================================================================                         
*/

public class ClosestBinarySearchTreeValue {

  public int closestValue(TreeNode root, double target) {
    return closestValue(root, target, -1, Integer.MAX_VALUE);
  }

  public int closestValue(TreeNode root, double target, int closestResult,
      double previousClosestDifference) {

    if (root == null) return closestResult;
    double currentClosestDifference = Math.abs(root.val - target);

    if (currentClosestDifference < previousClosestDifference) {
      previousClosestDifference = currentClosestDifference;
      closestResult = root.val;
    }
    // root.val=6..target=5.. 
    if (root.val > target)
      return closestValue(root.left, target, closestResult, previousClosestDifference);

    // root.val=5..target=6.. 
    if (root.val < target)
      return closestValue(root.right, target, closestResult, previousClosestDifference);

    // root.val=6..target=6.. 
    return closestResult; // return instantly if target and root.val matches  
  }
}
