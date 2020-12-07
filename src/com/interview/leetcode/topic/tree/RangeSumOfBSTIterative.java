package com.interview.leetcode.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/range-sum-of-bst/

                        10
                     /      \
                    5        20

 */
public class RangeSumOfBSTIterative {

  public int rangeSumBST(TreeNode root, int leftRange, int rightRange) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int rangeSum = 0;
    while (!q.isEmpty()) {
      root = q.poll();
      if (root == null) continue;
      if (root.val > rightRange) { // Ex: rootVal=10 leftRange=5 rightRange=7
        q.offer(root.left);
      } else if (root.val < leftRange) { // Ex: rootVal=10 leftRange=15 rightRange=20
        q.offer(root.right);
      } else {
        rangeSum += root.val;
        q.offer(root.left);
        q.offer(root.right);
      }
    }
    return rangeSum;
  }
}
