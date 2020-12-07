package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/symmetric-tree/description/
*
Ex:
				 	1
				   / \
				  2   2
				 / \ / \
				3  4 4  3


   boolean mirrorLeftRight = dfs(left.left, right.right); // Compare 3 with 3
   boolean mirrorRightLeft = dfs(left.right, right.left); // Compare 4 with 4

*/
public class SymmetricTreeTopDown {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    dfs(root.left, root.right);
    return answer;
  }

  boolean answer = true;

  public void dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) return;
    if (left == null || right == null || left.val != right.val) {
      answer = false;
      return;
    }
    dfs(left.left, right.right);
    dfs(left.right, right.left);
  }
}
