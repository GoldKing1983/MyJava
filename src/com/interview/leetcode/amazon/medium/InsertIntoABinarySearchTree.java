package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
===========================================================Requirement===========================================================
Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
insert the value into the BST
========================================================Solution Approach========================================================
1) The insertion will happen at right hand or left hand leaf only.
2) So traverse (left or right by comparing)all the way down.
When we find null, that is the point we need to insert data.
=================================================================================================================================
 */

public class InsertIntoABinarySearchTree {
  public TreeNode insertIntoBST(TreeNode root, int val) {
     
    TreeNode node = new TreeNode(val);
    if (root == null) return node;
    recur(root, node);
    return root;
  }

  private void recur(TreeNode root, TreeNode node) {
    if (root.val > node.val) {
      if (root.left == null) {
        root.left = node;
        return;
      }
      recur(root.left, node);
    } else {
      if (root.right == null) {
        root.right = node;
        return;
      }
      recur(root.right, node);
    }
  }
}
