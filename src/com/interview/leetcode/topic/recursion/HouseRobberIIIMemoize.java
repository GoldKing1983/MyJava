package com.interview.leetcode.topic.recursion;

import com.interview.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIIIMemoize {
    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);
        //======================Steal current======================
        // Decide to steal root. So keep rootVal as initial rootSum.
        int rootSum = root.val;
        // Add rootSumLeft to rootSum
        rootSum += root.left != null ? rob(root.left.left, dp) + rob(root.left.right, dp) : 0;
        // Add rootSumRight to rootSum
        rootSum += root.right != null ? rob(root.right.left, dp) + rob(root.right.right, dp) : 0;

        //======================Skip current======================
        int leftSum = rob(root.left, dp);
        int rightSum = rob(root.right, dp);

        //======================Result is max of steal and skip======================
        int maxAnswer = Math.max(rootSum, leftSum + rightSum);
        dp.put(root, maxAnswer);
        return maxAnswer;
    }
}
