package com.interview.leetcode.linkedin.easy;

import com.interview.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
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
 */
public class SameTreeTopDown {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queueP = new LinkedList<>();
    Queue<TreeNode> queueQ = new LinkedList<>();
    queueP.offer(p);
    queueQ.offer(q);

    while (!queueP.isEmpty()) {
      p = queueP.poll();
      q = queueQ.poll();

      if (p == null && q == null) continue;
      if (p == null || q == null) return false;
      if (p.val != q.val) return false;

      queueP.offer(p.left);
      queueQ.offer(q.left);
      queueP.offer(p.right);
      queueQ.offer(q.right);
    }

    return true;
  }
}
