package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Similar to ConstructBinarySearchTreeFromPreorderTraversal. See the analysis there.
Ex1: [1,2,3,4,5]
							3
						  /   \
						 2     4
					    /       \
					   1         5


 Ex2: [1,2,3,4,5,6,7]

 							4
 						  /   \
 						2       6
 					  /   \    /  \
  					 1     3  5    7
 */
public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    return convertSortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode convertSortedArrayToBST(int[] nums, int low, int high) {
    if (low > high) return null;
    // Ex: [1,2,3,4,5]... cutPoint=index2 or value3
    int cutPoint = low + (high - low) / 2;
    TreeNode root = new TreeNode(nums[cutPoint]);
    root.left = convertSortedArrayToBST(nums, low, cutPoint - 1);
    root.right = convertSortedArrayToBST(nums, cutPoint + 1, high);
    return root;
  }
}
