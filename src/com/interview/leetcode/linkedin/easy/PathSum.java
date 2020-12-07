package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/path-sum/description/
 *
 * Given a binary tree and a sum, determine if the tree has a "root-to-leaf path" such that
 * adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Case why null check needed on left.
 			5
 			 \
 			  4
Case why null check needed on right.
		   5
		  /
		 4
========================================Solution Approach========================================
 */
public class PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    sum -= root.val;
    if ((root.left == null) && (root.right == null)) return (sum == 0);
    boolean left = hasPathSum(root.left, sum);
    boolean right = hasPathSum(root.right, sum);
    return left || right;
  }
}
