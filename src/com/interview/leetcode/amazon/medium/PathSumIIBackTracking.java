package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
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
========================================================Solution Approach========================================================
1) Classic backtracking problem.
2) Add current node to currentPath during forward recursion.
When recursing back remove current node from currentPath.
3) When adding currentResult to result, make a copy.
==========================Time Complexity====================================================
1) Recursion takes O(n) times.
2) Copying currentResult to result takes O(n/2) equivalent to n, atmost for a complete binary tree.
3) So total of O(n^2)  


For complete binary trees, there exists many path to reach any leaf node and all path can be result

targetSum=3
			   1
		     /   \
		    1     1
		   / \   / \
		  1   1 1   1
Ex: for a 7 node complete binary tree. 4(n/2) paths are possible
path1  : 1 -> 1 -> 1
path2  : 1 -> 1 -> 1
path3  : 1 -> 1 -> 1
path4  : 1 -> 1 -> 1


*/

public class PathSumIIBackTracking {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    findPathsRecursive(root, targetSum, new ArrayList<>(), result);
    return result;
  }


  // Simplified recursion approach....
  private void findPathsRecursive(TreeNode root, int targetSum, ArrayList<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (root == null) return;

    currentPath.add(root.val);

    targetSum -= root.val;

    // if targetSum < 0... negative numbers can increment... so go all the way till leaf
    if (0 == targetSum && root.left == null && root.right == null) {
      allPaths.add(new ArrayList<>(currentPath));
    } else {
      findPathsRecursive(root.left, targetSum, currentPath, allPaths);
      findPathsRecursive(root.right, targetSum, currentPath, allPaths);
    }

    currentPath.remove(currentPath.size()-1);
  }

}
