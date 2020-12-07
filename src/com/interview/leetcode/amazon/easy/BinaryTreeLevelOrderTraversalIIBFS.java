package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).


Input:
 	3
   / \
  9  20
    /  \
   15   7
Output:
[
  [15,7],
  [9,20],
  [3]
]

*/
public class BinaryTreeLevelOrderTraversalIIBFS {

  public List<List<Integer>> levelOrderBottom1(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        currentLevel.add(currentNode.val);
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
      }
      result.add(0, currentLevel); // append the current level at the beginning
    }

    return result;
  }
}
