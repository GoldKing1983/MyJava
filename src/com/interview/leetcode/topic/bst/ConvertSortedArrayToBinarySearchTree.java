package com.interview.leetcode.topic.bst;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
See Also ConstructBinarySearchTreeFromPreorderTraversal
===========================================================Requirement===========================================================
1) Given a array of sorted number.
2) Build the BST. 

Input: nums = [-10,-3,0,5,9]


1) Call buildTree with lowerBound=0 and upperBound=n-1.
2) Take the mid. Construct Node.
3) Call buildTree with updated lowerBound and upperBound.
 
                    0
                /       \
              {-10-3}   {5,9}

                    0
                /       \
              -10       {5,9}
                \
                 {-3}
                 
                    0
                /       \
              -10       {5,9}
                \
                 -3

                    0
                /       \
              -10        5
                \         \
                 -3        {9}

                    0
                /       \
              -10        5
                \         \
                 -3        9


 */
public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  public TreeNode buildTree(int[] nums, int low, int high) {
    if (low > high) return null;
    // Ex: [1,2,3,4,5]... cutPoint=index2 or value3
    int cutPoint = low + (high - low) / 2;
    TreeNode root = new TreeNode(nums[cutPoint]);
    root.left = buildTree(nums, low, cutPoint - 1);
    root.right = buildTree(nums, cutPoint + 1, high);
    return root;
  }
}
