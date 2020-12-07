package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/cousins-in-binary-tree/

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

2comparism needs to be done.
1) Level should be equal
2) Parent should not be equal.

Level equal is done by keeping map outside for-loop.
			     6
			   /   \
			  3     5
			 / \   / \
			7   8 1   4
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.

 */
public class CousinsInBinaryTreeTopDownRecursion {

  public boolean isCousins(TreeNode root, int x, int y) {
    recur(root, null, new TreeNode[2], new Integer[2], 0, x, y);
    return isCousins;
  }

  boolean isCousins = false;

  private void recur(TreeNode root, TreeNode parent, TreeNode[] parentXY, Integer[] levelXY,
      int level, int x, int y) {
    if (root == null) return;

    if (root.val == x) {
      parentXY[0] = parent;
      levelXY[0] = level;
      TreeNode parentX = parentXY[0];
      TreeNode parentY = parentXY[1];
      Integer levelX = levelXY[0];
      Integer levelY = levelXY[1];

      if (parentX != parentY && levelX.equals(levelY)) isCousins = true;
    }
    if (root.val == y) {
      parentXY[1] = parent;
      levelXY[1] = level;
      TreeNode parentX = parentXY[0];
      TreeNode parentY = parentXY[1];
      Integer levelX = levelXY[0];
      Integer levelY = levelXY[1];

      if (parentX != parentY && levelX.equals(levelY)) isCousins = true;
    }
    recur(root.left, root, parentXY, levelXY, level + 1, x, y);
    recur(root.right, root, parentXY, levelXY, level + 1, x, y);
  }
}
