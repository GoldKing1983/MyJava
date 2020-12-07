package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/same-tree/
========================================================================================================
Requirement : Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
========================================================================================================
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
Output: true

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]
Output: false

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
Output: false
========================================================================================================
Runtime Complexity
Linear, O(n).

Memory Complexity
O(h)

The recursive solution has O(h) memory complexity as it will consume memory on the stack
up to the height of binary tree h. It will be O(log n) for a balanced tree and in the worst case can be O(n).
========================================================================================================
 */
public class SameTreeBottomUp {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    boolean isSameLeft = isSameTree(p.left, q.left);
    boolean isSameRight = isSameTree(p.right, q.right);
    return isSameLeft && isSameRight; // Change code to return left immediately, if false.
  }
}
