package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/range-sum-of-bst/
==================================================Initial Thinking==========================================================
1) If I traverse BST in InOrder, I will get sorted data. Save in list.
2) Find element between L & R
========================================Solution Approach - using BST property==============================================
1) Traverse tree in any of InOrder/PreOrder/PostOrder Traversal.
2) If root.val lies between L & R, add root.val to result.
3) Check method recurSimple
=========================================Solution Approach - using BST property - Optimized=================================
0) Along with above solution.
1) Go For Left only if root.val>L
2) Go For Right only if root.val<R
3) Check method recurOptimized
============================================================================================================================
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
   				  10
   				/    \
			   5	  15
		     /  \ 	 /	\
		    3    7  n   18

Output: 10+15+7=32
============================================================================================================================
 */
public class RangeSumOfBSTTopDown {

  int rangeSum = 0;

  public int rangeSumBST(TreeNode root, int leftRange, int rightRange) {
    recur(root, leftRange, rightRange);
    return rangeSum;
  }

  public void recur(TreeNode root, int leftRange, int rightRange) {
    if (root == null) return;
    // Ex: rootVal=10 leftRange=5 rightRange=7
    if (root.val > rightRange) recur(root.left, leftRange, rightRange);

    // Ex: rootVal=10 leftRange=15 rightRange=20
    else if (root.val < leftRange) recur(root.right, leftRange, rightRange);

    else {
      rangeSum += root.val;
      recur(root.left, leftRange, rightRange);
      recur(root.right, leftRange, rightRange);
    }

  }
}
