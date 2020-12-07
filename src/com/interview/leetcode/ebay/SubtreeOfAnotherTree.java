package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/subtree-of-another-tree/description/

====================================================Requirement==================================================================
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a 
subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be 
considered as a subtree of itself.
=======================================================Example1==================================================================
                                                Given tree s:
                                                     3
                                                    / \
                                                   4   5
                                                  / \
                                                 1   2
                                                Given tree t:
                                                   4 
                                                  / \
                                                 1   2
                                                Return true, because t has the same structure and node values with a subtree of s.
=======================================================Example2==================================================================
                                              Given tree s:
                                              
                                                   3
                                                  / \
                                                 4   5
                                                / \
                                               1   2
                                                  /
                                                 0
                                              Given tree t:
                                                 4
                                                / \
                                               1   2
                                              Return false.
=======================================================Solution Approach - Time Complexity O(m*n)================================
1) For each of node in "s" call isSame. 
2) Time Complexity O(m*n) - m is size of "s". n is size of "t" 
 *
 */
public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;

    // Moving this method to below like post-order will be slow, because it will traverse all nodes.
    if (isSame(s, t)) return true;

    boolean left = isSubtree(s.left, t);
    boolean right = isSubtree(s.right, t);
    return left || right;
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.val != t.val) return false;

    boolean left = isSame(s.left, t.left);
    boolean right = isSame(s.right, t.right);

    return left && right;
  }
}
