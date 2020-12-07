package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
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

====================================================Initial Thinking============================================================
1) BackTracking cannot be done with StringBuilder. Because, StringBuilder works by character level and
number can be more than one digit Ex:10. See "BinaryTreePathsClone" which uses StringBuilder.
2) So we save "path" of Tree in List. Once leaf found. Generate path with "->"
====================================================Solution Approach============================================================
1) Recursion receives only not-null root. If root==null return empty in mainMethod.
2) Add the rootValue to currentPath.
3) There are 4 case in total.
	Case1: Both left and right are null. leaf found. currentPath is complete. Save currentPath to result.
	Case2: Only left is null. Go right.
	Case3: Only right is null. Go left.
	Case4: Both are not null.  Go both the side.
4) Finally, remove the "lastValue" from currentPath i.e "backtrack".
 */
public class BinaryTreePathsBackTrackEasy {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) return result;
    recur(root, new LinkedList<>(), result);
    return result;
  }

  private void recur(TreeNode root, LinkedList<Integer> currentPath, List<String> result) {

    currentPath.add(root.val);

    if (root.left == null && root.right == null) result.add(convertToString(currentPath));
    else if (root.left == null) recur(root.right, currentPath, result);
    else if (root.right == null) recur(root.left, currentPath, result);
    else {
      recur(root.left, currentPath, result);
      recur(root.right, currentPath, result);
    }

    currentPath.removeLast();
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
