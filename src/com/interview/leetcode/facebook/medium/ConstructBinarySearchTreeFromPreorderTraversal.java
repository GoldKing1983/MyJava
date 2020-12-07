package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Return the root node of a binary search tree that matches the given preorder traversal.

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
							8
						   / \
						  5   10
						 / \   \
						1   7   12
========================================================================================================================
Observation1: FirstNode is root. From there whatever less should come at left.
								 From there whatever more should come at right.
								8
							  /   \
                         {5,1,7} {10,12}
==========================================Solution Approach=============================================================
1) For the given array find 3 things.
		1a) RootValue. It is at preorder[start].
		1b) LeftWindow. To Fill root's left.
				1bb) Find cutPoint. For above Ex: cutPoint is at index4. LeftWindow=start+1 to cutPoint-1
		1c) RightWindow. To Fill root's right.
				1cc) Find cutPoint. For above Ex: cutPoint is at index4. RightWindow=cutPoint to end.
2) Do step1 recursively.
3) If start>end return null.
=========================================================================================================================
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

  public TreeNode bstFromPreorder(int[] preorder) {
    return recur(preorder, 0, preorder.length - 1);
  }

  public TreeNode recur(int[] preorder, int start, int end) {
    if (start > end) return null;

    // Find LeftWindow and RightWindow
    int rootValue = preorder[start];
    int cutPoint;
    for (cutPoint = start; cutPoint <= end; cutPoint++) if (preorder[cutPoint] > rootValue) break;

    // cutPoint stops at index4. LeftWindow is 1to3 and rightWindow is 4to5
    TreeNode root = new TreeNode(rootValue);
    root.left = recur(preorder, start + 1, cutPoint - 1);
    root.right = recur(preorder, cutPoint, end);

    return root;
  }
}
