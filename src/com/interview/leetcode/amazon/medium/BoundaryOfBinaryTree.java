package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/boundary-of-binary-tree/

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
Boundary includes left boundary, leaves, and right boundary in order.

===========================================================Solution Approach=====================================================
1) Capture Root
2) Capture Left Boundary for root.left   ---- top-down order. So pre-order traversal
3) Capture Right Boundary for root.right ---- bottom-up order. So post-order traversal
4) Capture Leaf for both "root.left" and "root.right"
===============================================================Example1==========================================================
    					     _____1_____
    					    /           \
    					   2			 9
    					 /   \			/ \
    					4     5        n   n
     				   / \   / \
    				  6	  n 7   8

			Input: [1,2,9,4,5,null,null,6,null,7,8]
			Output: [1,2,4,6,7,8,9]
	1) 1 captured in main
	2) 2 and 4 are captured as left-boundary traversal
	3) 6,7,8 are captured as leaf traversal
	4) 9 captured as right-boundary traversal
===============================================================Example2==========================================================
					       _____1_____
					      /           \
						 9			   2
						/ \			 /   \
					   n   n		4     5
								   / \   / \
								  6	  n 7   8

			Input: [1,9,2,null,null,4,5,6,null,7,8]
			Output: [1,9,6,7,8,5,2]
	1) 1 captured in main
	2) 9 captured as left-boundary traversal
	3) 6,7,8 are captured as leaf traversal
	4) 5,2 captured as right-boundary traversal
=================================================================================================================================
 */
public class BoundaryOfBinaryTree {
  List<Integer> result = new ArrayList<>();

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) return result;
    result.add(root.val);
    if (root.left != null) {
      leftBoundary(root.left);
      leaves(root.left);
    }
    if (root.right != null) {
      leaves(root.right);
      rightBoundary(root.right);
    }

    return result;
  }

  // Boundary is either left or right. left has priority on "top to bottom" or "left boundary"
  public void leftBoundary(TreeNode root) {
    if (root.left == null && root.right == null) return; // ignore leaf
    result.add(root.val);
    if (root.left != null) leftBoundary(root.left);
    else leftBoundary(root.right);
  }

  // Boundary is either left or right. right has priority on  "bottom to top" or "right boundary"
  public void rightBoundary(TreeNode root) {
    if (root.right == null && root.left == null) return; // ignore leaf
    if (root.right != null) rightBoundary(root.right);
    else rightBoundary(root.left);
    result.add(root.val); // add after child visit(reverse)
  }

  public void leaves(TreeNode root) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      result.add(root.val);
      return;
    }
    leaves(root.left);
    leaves(root.right);
  }
}
