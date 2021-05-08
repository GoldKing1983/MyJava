package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * 1) Traverse by level order.
 * 2) if currentLeve is even insert at last, else insert at first.
 */
public class BinaryTreeZigzagLevelOrderTraversalUsingQueue {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int level = 0;
    while (!q.isEmpty()) {
      LinkedList<Integer> currResult = new LinkedList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        if (level % 2 == 0) currResult.add(node.val);
        else currResult.addFirst(node.val);

        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
      result.add(currResult);
      level++;

    }
    return result;
  }
}
