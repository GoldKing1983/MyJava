package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

See LowestCommonAncestorOfABinaryTreeOrLCADetail for detailed analysis
 */

public class LowestCommonAncestorOfABinaryTreeOrLCA {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root; // Note : we are returning parent. Not the found node.

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    // here I have root,left and right.... 
    return left == null ? right : (right == null ? left : root);
  }
}
