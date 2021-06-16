package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
			1
		1		3
	 2     1
For the above tree answer is 2.

	 ========Solution Thinking=========
1) Here as per problem definition, root is always MIN1.
2) So the problem is same as an array having 1st element as MIN1. Find MIN2.
3) So set MIN2 as max value.
4) Verify if current falls between MIN1 and MIN2, then update MIN2 with current.
=================================


 */
public class SecondMinimumNodeInABinaryTree {
  int min1;
  long min2 = Long.MAX_VALUE;


  public void dfs(TreeNode root) {
    if (root == null) return;
    if (min1 < root.val && min2 > root.val) { //isCurrentFallsBetweenMIN1AndMIN2
      min2 = root.val;
    }
    dfs(root.left);
    dfs(root.right);
  }

  public int findSecondMinimumValue(TreeNode root) {
    min1 = root.val;
    dfs(root);
    return (int) min2;
  }
}
