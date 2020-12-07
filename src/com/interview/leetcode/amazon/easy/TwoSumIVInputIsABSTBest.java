package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;
/*

Ex:
			Ex:  2,1,3
							2
						  /	  \
						 1	   3
			For the above case I need to go in left and right.


 */
public class TwoSumIVInputIsABSTBest {

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) return false;

    return dfs(root, root, k);
  }

  private boolean dfs(TreeNode root, TreeNode curr, int k) {
    if (curr == null) return false;
    return search(root, curr, k - curr.val) || dfs(root, curr.left, k) || dfs(root, curr.right, k);
  }

  private boolean search(TreeNode root, TreeNode curr, int value) {
    if (root == null) return false;
    if (root.val == value && curr != root) return true;

    if (root.val < value) return search(root.right, curr, value);
    if (root.val > value) return search(root.left, curr, value);

    return false;
  }
}
