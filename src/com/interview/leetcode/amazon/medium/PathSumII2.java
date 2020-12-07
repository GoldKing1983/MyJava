package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 *
https://leetcode.com/problems/path-sum-ii/

Given the below binary tree and sum = 22,
Input:
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
Output:
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]

====================================Solution Approach=============================================
1) Simple Forward Recursion from root to leaf.
2) for each child, create new path and save it.
==========================Time Complexity O(n)====================================================
Below code is strictly O(n). Because each node visited exactly once. No backtracking.
But it take too much memory and too much push/pop operation.

			   1
		     /   \
		    2     3
		   / \   / \
		  4   5 6   7
Ex: for a 7 node complete binary tree. 4 paths are possible
path1  : 1 -> 2 -> 4
path2  : 1 -> 2 -> 4
path3  : 1 -> 3 -> 6
path4  : 1 -> 3 -> 7


*/

public class PathSumII2 {
  static class Path {
    public TreeNode node;
    public int sum;
    public List<Integer> path;

    public Path(TreeNode node, int sum, List<Integer> path) {
      this.node = node;
      this.sum = sum;
      this.path = path;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Deque<Path> stack = new ArrayDeque<>();
    stack.push(new Path(root, root.val, new ArrayList<>(Arrays.asList(root.val))));

    while (!stack.isEmpty()) {
      Path prevPath = stack.pop();
      TreeNode node = prevPath.node;
      Integer currentSum = prevPath.sum;
      List<Integer> path = prevPath.path;
      if (node.left == null && node.right == null && currentSum == sum) result.add(path);
      if (node.left != null) {
        List<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(node.left.val);
        stack.push(new Path(node.left, currentSum + node.left.val, currentPath));
      }
      if (node.right != null) {
        List<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(node.right.val);
        stack.push(new Path(node.right, currentSum + node.right.val, currentPath));
      }
    }
    return result;
  }
}
