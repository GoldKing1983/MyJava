package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

1) A tree has 3 points in traversing if I do left and right recursively.
2) Point b4 left. where root is processed.
3) Point after left or Point b4 right. where left is processed.
4) Point after right. where right is processed
5) Here in this problem, I will take the Point b4 left i.e root processing. Or PreOrder Traversal.

========
Refer Problem "FindLeavesOfBinaryTreeBottomUpRecurse.java"
=========
1) This solution approach does in O(n).
2) Don't use ArrayList which adds element at 0. which moves element exists that is another O(n) operation for each odd row.
 *
 */
public class BinaryTreeZigzagLevelOrderTraversalRecursionBest {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    return recur(root, 0, new ArrayList<>());
  }

  private List<List<Integer>> recur(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return result;
    if (result.size() == level) result.add(new LinkedList<>());
    if (level % 2 == 0) ((LinkedList<Integer>) result.get(level)).addLast(root.val);
    else((LinkedList<Integer>) result.get(level)).addFirst(root.val);
    recur(root.left, level + 1, result);
    return recur(root.right, level + 1, result);
  }
}
