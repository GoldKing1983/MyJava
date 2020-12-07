package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/cousins-in-binary-tree/

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
Both the searchNode will present all the time tree. 

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
Say two node be 7 and 4, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.

===============Solution Approach==========
1) Traverse in level order.
2) x or y can present in either left or right. If present update parent.
3) At each level of parsing, verify if both parents are present.
	If YES verify both parent are different and break the logic to return true or false.
=========================DFS vs BFS=========
1) BFS is better than DFS. Because we don't have to go all the way to leaf.
 */
public class CousinsInBinaryTree {

  public boolean isCousins(TreeNode r, int x, int y) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(r);
    List<TreeNode> parent = new ArrayList<>();
    while (!q.isEmpty()) {
      int s = q.size();
      for (int i = 0; i < s; ++i) {
        TreeNode root = q.poll();
        if (root.left != null) {
          if (x == root.left.val || y == root.left.val) parent.add(root);
          q.add(root.left);
        }
        if (root.right != null) {
          if (x == root.right.val || y == root.right.val) parent.add(root);
          q.add(root.right);
        }
      }
      // If at any level, only one child is found, then return false.
      if (parent.size() == 1) return false;
      // If at any level, both childs are found, then return true, if both parents are different.
      if (parent.size() == 2) {
        return parent.get(0).val != parent.get(1).val;
      }
    }
    return false;
  }
}
