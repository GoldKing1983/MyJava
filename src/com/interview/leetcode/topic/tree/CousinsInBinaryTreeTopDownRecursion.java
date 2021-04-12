package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/cousins-in-binary-tree/
===========================================================Requirement===========================================================
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

Constraints : input Number will be from 1 to 100 only.

2comparism needs to be done.
1) Level should be equal
2) Parent should not be equal.

			     6
			   /   \
			  3     5
			 / \   / \
			7   8 1   4
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.
========================================================Solution Approach========================================================
1) If x or y is found in recursion, cache the level and parent. 
2) If level is same and parent is different. 

 */
public class CousinsInBinaryTreeTopDownRecursion {

  public boolean isCousins(TreeNode root, int x, int y) {
    return recur(root, -1, 0, x, y);
  }

  int parentX, parentY, levelX, levelY;
  boolean xFound = false, yFound = false;

  private boolean recur(TreeNode root, int parent, int level, int x, int y) {
    if (root == null) return false;

    if (root.val == x) {
      parentX = parent;
      levelX = level;
      xFound = true;
      if (yFound) {
        return (parentX != parentY && levelX == levelY);// Both x and y were found. Return by condition
      }
    }
    if (root.val == y) {
      parentY = parent;
      levelY = level;
      yFound = true;
      if (xFound) {
        return (parentX != parentY && levelX == levelY);// Both x and y were found. Return by condition
      }
    }
    boolean left = recur(root.left, root.val, level + 1, x, y);
    boolean right = recur(root.right, root.val, level + 1, x, y);
    return left || right;
  }
}
