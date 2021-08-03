package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/path-sum-ii
===========================================================Requirement===========================================================
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum
equals targetSum. A leaf is a node with no children.
============================================================Example1=============================================================
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


*/

public class PathSumIITopToBottomCloneApproach {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    findPathsRecursive(root, targetSum, new ArrayList<>(), allPaths);
    return allPaths;
  }

  private void findPathsRecursive(TreeNode root, int targetSum, ArrayList<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (root == null) return;

    currentPath.add(root.val);
    targetSum -= root.val;

    if (root.left == null && root.right == null && 0 == targetSum) {
      allPaths.add(currentPath);
    } else {
      findPathsRecursive(root.left, targetSum, new ArrayList<>(currentPath), allPaths);
      findPathsRecursive(root.right, targetSum, new ArrayList<>(currentPath), allPaths);
    }

  }
}
