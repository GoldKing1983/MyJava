package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/path-sum/description/
===========================================================Requirement===========================================================
1) Given a binary tree and a sum. 
2) Determine if the tree has a "root-to-leaf path" such that adding up all the values along the path equals the given sum.
============================================================Example1=============================================================
Input: root = [1,2,3], targetSum = 5
Output: false
                  1
                 / \
                2   3
============================================================Example2=============================================================                  
Input: root = [1,2,3,4], targetSum = 7
Output: true
                  1
                 / \
                2   3
               /
              4
========================================================Solution Approach========================================================
1) Subtract the node with the target. 
2) On the leaf, if the target reaches 0. Return true. Else Return false.

TopToBottom : Do add/subtract
BottomToTop : return result.

Tricky.... Don't try to remove/improve Base Condition. 
 */
public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false; // Base Condition. Ex1:[] return false. Ex2: [1,2] for root1 right is null. So it has to return false. 

    targetSum -= root.val;

    if (root.left == null && root.right == null) return targetSum == 0; // Reached leaf

    boolean left = hasPathSum(root.left, targetSum);
    boolean right = hasPathSum(root.right, targetSum);

    return left || right;
  }

}
