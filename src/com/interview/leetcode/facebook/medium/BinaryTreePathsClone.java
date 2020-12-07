package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-paths/

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Input:
							   1
							 /   \
							2     3
							 \
							  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePathsClone {
  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return new ArrayList<>();
    recur(root, new StringBuilder());
    return result;
  }

  List<String> result = new ArrayList<>();

  private void recur(TreeNode root, StringBuilder currentResult) {
    if (root == null) return;

    currentResult.append(root.val);

    if (root.left == null && root.right == null) {
      result.add(currentResult.toString());
      return;
    }

    StringBuilder leftClone = new StringBuilder(currentResult);
    leftClone.append("->");
    recur(root.left, leftClone);

    StringBuilder rightClone = new StringBuilder(currentResult);
    rightClone.append("->");
    recur(root.right, rightClone);
  }
}
