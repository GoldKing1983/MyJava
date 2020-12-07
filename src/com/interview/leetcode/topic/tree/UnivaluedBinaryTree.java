package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*

===========================================================Requirement===========================================================
A binary tree is univalued if every node in the tree has the same value.

If any one node has different value return false. 
input will have minimum 1 node. 

 */
public class UnivaluedBinaryTree {
  public boolean isUnivalTree(TreeNode root) {
    return recur(root, root.val);
  }

  private boolean recur(TreeNode root, int parent) {
    if (root == null) return true;
    if (root.val != parent) return false;
    boolean left = recur(root.left, parent);
    boolean right = recur(root.right, parent);
    return left && right;
  }
}
