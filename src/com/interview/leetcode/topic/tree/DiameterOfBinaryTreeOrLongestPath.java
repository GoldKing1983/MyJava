package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/description/
===========================================================Requirement===========================================================
Given a tree, return maximum width of tree.
========================================================Solution Approach========================================================
1) Solution is based on TreeHeight
2) From Bottom-Up return the heights, at any-point diameter = leftTreeHeight + rightTreeHeight
3) Return either left or right max to get the biggest path
===================================================================================================================

Same code as tree height, with 2 changes
1) return 0. instead of -1.
2) add 1 extra line, which stores maxDiameter from left and right total.
===================================================================================================================
 Note: result is not the number of nodes. result is number of edges(connecting line)

 ==============================================Data Flow Analysis======================================================================
 		  1
         / \
        2   3  maxDiameter=2
    =======Bottom-Up Recursion view===============
	For Node:2 leftHeight:0 rightHeight:0 return:1
	For Node:3 leftHeight:0 rightHeight:0 return:1
	For Node:1 leftHeight:1 rightHeight:1 return:2

==============================================Data Flow Analysis======================================================================
 		  1
         / \
        2   3
       / \
      4   5    maxDiameter=3
    =======Bottom-Up Recursion view===============
	For Node:4 leftHeight:0 rightHeight:0 return:1
	For Node:5 leftHeight:0 rightHeight:0 return:1
	For Node:2 leftHeight:1 rightHeight:1 return:2
	For Node:3 leftHeight:0 rightHeight:0 return:1
	For Node:1 leftHeight:2 rightHeight:1 return:3

*/
public class DiameterOfBinaryTreeOrLongestPath {

  public int diameterOfBinaryTree(TreeNode root) {
    recur(root);
    return maxDiameter;
  }

  int maxDiameter = 0;

  private int recur(TreeNode root) {
    if (root == null) return 0;
    int leftTreeHeight = recur(root.left);
    int rightTreeHeight = recur(root.right);
    int currentDiameter = leftTreeHeight + rightTreeHeight;
    maxDiameter = Math.max(maxDiameter, currentDiameter);
    return Math.max(leftTreeHeight, rightTreeHeight) + 1;
  }
}
