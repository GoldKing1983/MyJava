package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

This problem can be solved only by post-order traversal.

1) Verify if a node is validBST or not. If yes, stop proceeding further. Calculate sum of nodes.
                                        Else go left and right... do Step1.

Similar to ValidateBinarySearchTreeOrValidBSTPostOrderApproach

 */
public class MaximumSumBSTInBinaryTree {
  private int maxSum = 0;

  public int maxSumBST(TreeNode root) {
    postOrderTraverse(root);
    return maxSum;
  }

  private int[] postOrderTraverse(TreeNode root) {
    if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}, initialize min=MAX_VALUE, max=MIN_VALUE
    int[] left = postOrderTraverse(root.left);
    int[] right = postOrderTraverse(root.right);
    if (!(left != null && right != null && root.val > left[1] && root.val < right[0])) return null;
    int sum = root.val + left[2] + right[2]; // now it's a BST make `root` as root
    maxSum = Math.max(maxSum, sum);
    int min = Math.min(root.val, left[0]);
    int max = Math.max(root.val, right[1]);
    return new int[] {min, max, sum};
  }
}
