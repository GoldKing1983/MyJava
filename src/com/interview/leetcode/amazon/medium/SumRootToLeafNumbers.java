package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Similar to PathSumII2.java

====================================Solution Approach=============================================
1) Simple Forward Recursion from root to leaf.
2) for each child, create new path and save it in StringBuilder.
==========================Time Complexity O(n)====================================================
Below code is strictly O(n). Because each node visited exactly once. No backtracking.
But it take too much memory and too much push/pop/append operation.

			   1
		     /   \
		    2     3
		   / \   / \
		  4   5 6   7
Ex: for a 7 node complete binary tree. 4 paths are possible
path1  : 1 -> 2 -> 4
path2  : 1 -> 2 -> 5
path3  : 1 -> 3 -> 6
path4  : 1 -> 3 -> 7

 */
public class SumRootToLeafNumbers {
  public int sumNumbers(TreeNode root) {
    List<StringBuilder> result = new ArrayList<>();
    if (root == null) return 0;
    Deque<Object[]> stack = new ArrayDeque<>();
    stack.push(new Object[] {root, new StringBuilder(root.val + "")});
    while (!stack.isEmpty()) {
      Object[] prevPath = stack.pop();
      TreeNode node = (TreeNode) prevPath[0];
      StringBuilder path = (StringBuilder) prevPath[1];
      if (node.left == null && node.right == null) result.add(path);
      if (node.left != null) {
        StringBuilder currentPath = new StringBuilder(path);
        currentPath.append(node.left.val);
        stack.push(new Object[] {node.left, currentPath});
      }
      if (node.right != null) {
        StringBuilder currentPath = new StringBuilder(path);
        currentPath.append(node.right.val);
        stack.push(new Object[] {node.right, currentPath});
      }
    }
    int sum = 0;
    for (StringBuilder str : result) sum += Integer.valueOf(str.toString());

    return sum;
  }
}
