package com.interview.leetcode.amazon.easy;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the "root node down" to the nearest "leaf node".

Note: A leaf is a node with no children.
=============================Example=======================================
 1) if input is {1, 2}. The expected result is 2. Because 1 is not a leaf node.
 					1
 				   /
 				  2

 2) if input is {1, 2, null, null, 3}. The expected result is 3. Because, the path must be end with a leaf node.
 					1
 				   / \
 				  2   n
 		         / \
 		        n   3
 */
public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left != null && root.right != null)
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    if (root.left != null) return minDepth(root.left) + 1;

    return minDepth(root.right) + 1;

  }


  public int minDepth1(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) q.offer(root);
    int minDepth = 0;
    while (!q.isEmpty()) {
      minDepth++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        if (curr.left == null && curr.right == null) return minDepth;
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }
    }
    return minDepth;
  }
}
