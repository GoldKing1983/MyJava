package com.interview.leetcode.topic.recursion;

import com.interview.leetcode.TreeNode;

/*
 https://leetcode.com/problems/house-robber-iii/
===========================================================Requirement===========================================================
 Given a tree, thief cannot steal on 2 neighbor nodes.
========================================================Solution Approach========================================================
Ex:
                         1
                       /   \
                      2     3
                     / \   / \
                    4  5  6   7
Assume there are 7 houses. There are only 2 case possible
1) If thief choose to steal root1. Then he can steal 4And5 and 6And7.
2) If thief skip root1. Then max is sum of 2And3.

 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        //======================Steal current======================
        // Decide to steal root. So keep rootVal as initial rootSum.
        int rootSum = root.val;
        // Add rootSumLeft to rootSum
        rootSum += root.left != null ? rob(root.left.left) + rob(root.left.right) : 0;
        // Add rootSumRight to rootSum
        rootSum += root.right != null ? rob(root.right.left) + rob(root.right.right) : 0;

        //======================Skip current======================
        int leftSum = rob(root.left);
        int rightSum = rob(root.right);

        //======================Result is max of steal and skip======================
        return Math.max(rootSum, leftSum + rightSum);
    }
}
