package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/symmetric-tree/description/

Ex:
				 	1
				   / \
				  2   2
				 / \ / \
				3  4 4  3


   boolean mirrorLeftRight = dfs(left.left, right.right); // Compare 3 with 3
   boolean mirrorRightLeft = dfs(left.right, right.left); // Compare 4 with 4

*/
public class SymmetricTreeBottomUp {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return dfs(root.left, root.right);
  }

  public boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;
    boolean mirrorLeftRight = dfs(left.left, right.right);
    boolean mirrorRightLeft = dfs(left.right, right.left);
    return mirrorLeftRight && mirrorRightLeft;
  }
}
