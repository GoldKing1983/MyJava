package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
We can argue Time Complexity is n(log(n)) or n^2.
Below is argument about n(log(n))
For binary trees, there exists only one path to reach any leaf node,
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

A path will take log(n) times.
Total number of leaf is n/2 equivalent to n.
So total is n(log(n))

*/

public class PathSumII {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        LinkedList<Integer> currentPath = new LinkedList<>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private void findPathsRecursive(TreeNode currentNode, int sum, LinkedList<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);
        if (currentNode.left == null && currentNode.right == null) {
            if (currentNode.val == sum) allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }
        currentPath.removeLast();
    }
}
