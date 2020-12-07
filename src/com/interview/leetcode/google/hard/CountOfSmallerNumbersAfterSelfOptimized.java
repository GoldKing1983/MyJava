package com.interview.leetcode.google.hard;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
=========================================================================================================================
Input: [5,2,6,1,1]
Output: [3,2,2,0,0]
Explanation:
To the right of 5 there are 3 smaller elements (2,1,1).
To the right of 2 there are 2 smaller element (1,1).
To the right of 6 there are 3 smaller element (1,1).
To the right of 1 there is 0 smaller element.
To the right of 1 there is 0 smaller element.
==============================================Solution Approach===========================================================
See Picture "CountOfSmallerNumbersAfterSelfBST.png"  BST Tree.
 */

class TreeNode {
  TreeNode left = null;
  TreeNode right = null;
  int val;
  int count = 1;
  int leftCount = 0;

  TreeNode(int val) {
    this.val = val;
  }
}

public class CountOfSmallerNumbersAfterSelfOptimized {
  public List<Integer> countSmaller(int[] nums) {
    Integer[] result = new Integer[nums.length];
    TreeNode head = null;
    for (int i = nums.length - 1; i >= 0; i--) head = insert(head, nums[i], 0, result, i);
    return Arrays.asList(result);
  }

  TreeNode insert(TreeNode root, int val, int leftCount, Integer[] nums, int i) {
    if (root == null) {
      nums[i] = leftCount;
      return new TreeNode(val);
    }
    if (root.val == val) {
      nums[i] = root.leftCount + leftCount;
      root.count += 1;
      return root;
    }
    if (root.val < val) {
      root.right = insert(root.right, val, leftCount + root.count + root.leftCount, nums, i);
      return root;
    }
    root.leftCount += 1;
    root.left = insert(root.left, val, leftCount, nums, i);
    return root;
  }
}
