package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/find-all-the-lonely-nodes/
=========================================================Requirement=============================================================
In a binary tree, a lonely node is a node that is the only child of its parent node. 
Ex: If a parent has only leftChild or rightChild. Then anyone child is considered lonely.   

Given the root of a binary tree, return an all lonely nodes in the tree. Return the list in any order.
==========================================================Solution Approach======================================================
1) If both left and right is null. Then it is not considered lonely. Reached end.
2) If left is null, then right is lonely. Traverse towards right.
3) If right is null, then left is lonely. Traverse towards left.
4) Else both left and right are not lonely. Traverse both the side.
 */
public class FindAllTheLonelyNodes {
  public List<Integer> getLonelyNodes(TreeNode root) {
    return recur(root, new ArrayList<>());
  }

  private List<Integer> recur(TreeNode root, List<Integer> result) {
    if (root.left == null && root.right == null) return result;
    if (root.left == null) {
      result.add(root.right.val);
      return recur(root.right, result);
    }
    if (root.right == null) {
      result.add(root.left.val);
      return recur(root.left, result);
    }
    recur(root.left, result);
    return recur(root.right, result);

  }
}
