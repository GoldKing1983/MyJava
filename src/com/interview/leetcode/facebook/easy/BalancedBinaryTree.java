package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
====================================================Requirement==================================================================
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
=======================================================Example1==================================================================
Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.
=======================================================Example2==================================================================
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
====================================================Solution Approach============================================================
1) Solution is based on modified treeHeight.
2) if the difference between leftHeight and rightHeight is greater than 1. Set result to false.
====================================================Data Flow Analysis===========================================================
Calling TreeHeight for left and right will fail
									   1
								      / \
								     2   2
								    / \
								   3   3
								  / \
								 4   4

for node 4 left is 0 right is 0
for node 4 left is 0 right is 0
for node 3 left is 1 right is 1
for node 3 left is 0 right is 0
for node 2 left is 2 right is 1
for node 2 left is 0 right is 0
for node 1 left is 3 right is 1 --> false here


 */
import com.interview.leetcode.TreeNode;

public class BalancedBinaryTree {
  boolean result = true;

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    height(root);
    return result;
  }

  public int height(TreeNode root) {
    if (root == null) return 0;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    if (Math.abs(rightHeight - leftHeight) > 1) {
      result = false;
      return 0; // exit recursion
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }

}
