package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
 * A tree containing a single node has a height of 0, if we count by edges.
 * A tree containing a single node has a height of 1, if we go by node count.
 *
 * Note:To return the count of nodes "return 0" in recursive base condition.
 * https://www.youtube.com/watch?v=_pnqMz5nrRs at 5.02 timing
 * https://www.youtube.com/watch?v=_SiwrPXG9-g --- understanding call stack...
 *
 *  Time Complexity : O(n)
 */
public class TreeHeightTopDown {

  public int maxDepth(TreeNode root) {
    recur(root, 1);
    return maxDepth;
  }

  int maxDepth = 0;

  private void recur(TreeNode root, int level) {
    if (root == null) return;
    maxDepth = Math.max(maxDepth, level);
    recur(root.left, level + 1);
    recur(root.right, level + 1);
  }
}
