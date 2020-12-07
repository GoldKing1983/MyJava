package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/count-complete-tree-nodes/description/
Must see video---https://www.youtube.com/watch?v=4wPlA_InnGY&feature=youtu.be
=================================Requirement==================================================================================
Given a complete binary tree, count the number of nodes.

	Input:
		    1
		   / \
		  2   3
		 / \  /
		4  5 6

	Output: 6

Complete Binary Trees are filled from left to right "strictly".
So left side might(or equal) be having 1 node greater than right side.
============================Solution Approach1 - Time Complexity: O(n) ======================
1) Check method "CountCompleteBinaryTreeNodesWorstApproach"  which fails.
2) The code is similar to height of tree with "return as 0 if null" and without (Math.max)
=================================Solution Behind O(log n)=============================================================================
1) Use the property of full binary tree. A binary tree where all nodes are filled.
2) totalNodes = 2^h-1.
3) So for below. I can do just leftNodesCount or leftNodesCount which is 3. Then ans= 2^3-1=7

Input:
		       1
		    /     \
		   2       3
		  / \     / \
		 4   5   6   7
===============================Solution approach2 - log(n) ===================================
1) From CountCompleteBinaryTreeNodesWorstApproach code, add Base Condition if any node is FullBinaryTree then, return (2^h)-1
2) To verify if a node is FullBinaryTree, get rightCount and leftCount. If both same then it is FullBinaryTree, return (2^h)-1
==========================================Note====================================================================
1) When the tree is properly balanced and tree is big. The logic will be very efficient.
2) Worst case it has to visit most node. Sometimes even more than n nodes for smaller tree.
Check diagram "CountCompleteTreeNodes_WorstCase.jpg" and "CountCompleteTreeNodes_BestCase.jpg".
=====================================Data Flow Analysis==============================================================================
	Input:
		    1 Ans= (3+2+1)
		   / \
	   (3)2   3(2)
		 / \  /
		4  5 6

	Output: 6

Node2 is CompleteBinaryTree . So it returns 3.
Node6 is CompleteBinaryTree . So it returns 1.
Node3 returns 2.
Node1 returns 3+2+1=6
=====================================Data Flow Analysis==============================================================================
	Input:
		       1
		    /     \
		   2       3
		 /  \     / \
		4    5   6   7
	   / \   /
	  8   9 10

	Output: 10

Node4 is CompleteBinaryTree . So it returns 3.
Node10 is CompleteBinaryTree . So it returns 1.
Node3 is CompleteBinaryTree . So it returns 3.
From there return "left and right + 1" all the way up.
===================================================================================================================
*/
public class CountCompleteBinaryTreeNodes {

  /*
  O (log(n))
  */
  public int countNodes(TreeNode root) {

    int currentLeftCount = leftNodesCount(root);
    int currentRightCount = rightNodesCount(root);
    if (currentLeftCount == currentRightCount) { // Exit Condition
      return (int) Math.pow(2, currentLeftCount) - 1; // return (1 << leftHeight) - 1;
    }
    int leftCount = countNodes(root.left);
    int rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
  }

  private int leftNodesCount(TreeNode root) {
    if (root == null) return 0;
    return 1 + leftNodesCount(root.left); // return leftHeight(root.left) + 1;
  }

  private int rightNodesCount(TreeNode root) {
    if (root == null) return 0;
    return 1 + rightNodesCount(root.right); // return rightHeight(root.right) +1;
  }
}
