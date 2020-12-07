package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
=========================================================Requirement=============================================================
https://leetcode.com/problems/count-univalue-subtrees/

Given the root of a binary tree, return the number of uni-value subtrees.
A uni-value subtree means left and right of subtree have the same value(or either null(null is like Joker Card)) from bottom-up.

Input: root = [5,1,5,5,5,null,5]
Output: 4
 							5
 						  /   \
 						 1	   5
 						/ \   / \
 					   5   5 n   5
 
=====================================================Solution Approach - O(NlogN)================================================

1) From botoomToTop, if the left/right/root.val all 3 are same then uniValueTreeResultCount chain continues.
   For the leafNode, left and right are null. We can consider null as Joker and it matches with leafNode value.
2) Else it cannot go further from botoomToTop or the result chain stops.

Node values are from -1000 to 1000.
So here we are using -1001 to indicate null returned at leaf.
1001 to indicate Chain broke from bottom to top.

 */
public class CountUnivalueSubtrees {
  public int countUnivalSubtrees(TreeNode root) {
    recur(root);
    return uniValueTreeResultCount;
  }

  int uniValueTreeResultCount = 0;

  private int recur(TreeNode root) {
    if (root == null) return -1001;
    int left = recur(root.left);
    int right = recur(root.right);

    if ((left == -1001 && right == -1001) || (left == -1001 && root.val == right)
        || (right == -1001 && root.val == left) || (root.val == left && root.val == right)) {
      uniValueTreeResultCount++;
      return root.val; // uniValueTree chain continues from bottom
    }

    return 1001; // uniValueTree chain broke from bottom
  }
}
