package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/trim-a-binary-search-tree/

				    3
				   / \
				  0   4
				   \
				    2
				   /
				  1
=================================================================================================================================
				L = 1
  				R = 3
			Output:
					      3
					     /
					   2
					  /
					 1
======================================================Root Changed for Below=====================================================
				L = 0
				R = 2
			Output:
						  0
						   \
						    2
						   /
						  1
============================Root Changed for Below==========
				L = 0
				R = 1
			Output:
						  0
						   \
						    1
==============================================================Solution Approach==================================================
There 3 cases in total depends on the root value and L, R

1) If root.val > R, trim right. root is skipped. recurse left.
2) If root.val < L, trim left. root is skipped. recurse right.
3) Else, root is valid result. Go Left and Right. Assign left to left and right to right

See MergeTwoSortedLists.java for how connection broke and connection happens again between left and right

Look into RangeSumOfBSTBottomUp which is similar
 */
public class TrimABinarySearchTreeRecursionMust {

  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) return null;

    if (root.val > high) return trimBST(root.left, low, high);
    if (root.val < low) return trimBST(root.right, low, high);

    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
  }


}
