package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.interview.leetcode.TreeNode;

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

====================================================Initial Thinking============================================================
1) BackTracking cannot be done with StringBuilder. Because, StringBuilder works by character level and
number can be more than one digit Ex:10. See "BinaryTreePathsClone" which uses StringBuilder.
2) So we save "path" of Tree in List. Once leaf found. Generate path with "->"
====================================================Solution Approach============================================================

1) Add the rootValue to currentPath.
2) If (root.left==null && root.right==null), leaf found. currentPath is complete. Save currentPath to result.
3) If leftPath is available goLeft and do backTrack below it.
3) If rightPath is available goRight and do backTrack below it.
 */
public class BinaryTreePathsBackTrack {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> results = new ArrayList<>();
    if (root == null) return results;
    recur(root, new LinkedList<>(), results);
    return results;
  }

  private void recur(TreeNode root, LinkedList<Integer> currentPath, List<String> result) {

    currentPath.add(root.val);

    if (root.left == null && root.right == null) {
      result.add(convertToString(currentPath));
      return;
    }

    if (root.left != null) {
      recur(root.left, currentPath, result);
      currentPath.removeLast();
    }
    if (root.right != null) {
      recur(root.right, currentPath, result);
      currentPath.removeLast();
    }
  }

  private String convertToString(List<Integer> path) {
    StringBuilder currentResult = new StringBuilder();
    for (Integer number : path) {
      currentResult.append(number);
      currentResult.append("->");
    }
    return currentResult.substring(0, currentResult.length() - 2); // skip "->"
  }
}
