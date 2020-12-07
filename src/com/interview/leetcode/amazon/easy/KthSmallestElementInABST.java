package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

========================================Solution=====================================
1) Traversing BST in InOrder Traversal gives result in Ascending Order.
2) So if I traverse in InOrder Traversal, then problem is like in an sorted array, find the k-th element
3) Decrement k in in-order-traversal location. If k==0 result found.

Note: There is no bottom-up solution found/possible. 
 */
public class KthSmallestElementInABST {
  int k = 0;
  int result = 0;

  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    recur(root);
    return result;
  }

  private void recur(TreeNode root) {
    if (root == null || k == 0) return;
    recur(root.left);
    k--;
    if (k == 0) result = root.val;
    recur(root.right);
  }
}
