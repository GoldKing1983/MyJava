package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/maximum-average-subtree/

                  1
               /     \
              2       3
             / \     / \
            4   5   6   7

actual root.val : 4. updated root.val : 4. nodeCount : 1. max average : 4.0
actual root.val : 5. updated root.val : 5. nodeCount : 1. max average : 5.0
actual root.val : 2. updated root.val : 11. nodeCount : 3. max average : 5.0
actual root.val : 6. updated root.val : 6. nodeCount : 1. max average : 6.0
actual root.val : 7. updated root.val : 7. nodeCount : 1. max average : 7.0
actual root.val : 3. updated root.val : 16. nodeCount : 3. max average : 7.0
actual root.val : 1. updated root.val : 28. nodeCount : 7. max average : 7.0

        1) Bottom-Up fashion. Post-Order Traversal.
        2) Update root with sum of left.val+right.val+root.val
        3) Return the count of nodes in response.
        4) Update average in each point.

 */
public class MaximumAverageSubtree {
  private double average = 0;

  public double maximumAverageSubtree(TreeNode root) {
    helper(root);
    return average;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    int nodeCount = left + right + 1;
    if (root.left != null) root.val += root.left.val;
    if (root.right != null) root.val += root.right.val;
    average = Math.max(average, (double) (root.val) / nodeCount);
    return nodeCount;
  }
}
