package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/search-in-a-binary-search-tree/

 */
public class SearchInABinarySearchTree {
  public TreeNode searchBSTIteration(TreeNode root, int val) {
    while (root != null) {
      if (root.val < val) root = root.right;
      else if (root.val > val) root = root.left;
      else return root;
    }
    return null;
  }

  // Bottom-Up Recursion
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    // if (root.val == val) return root;
    if (root.val < val) return searchBST(root.right, val);
    if (root.val > val) return searchBST(root.left, val);
    return root;
  }
}
