package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

 */
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    return recur(root, new ArrayList<>());
  }

  private List<Integer> recur(TreeNode root, List<Integer> result) {
    if (root == null) return result;
    recur(root.left, result);
    result.add(root.val);
    return recur(root.right, result);
  }
}
