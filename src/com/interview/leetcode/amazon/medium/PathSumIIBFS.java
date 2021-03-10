package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*


*/

public class PathSumIIBFS {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, root.val, new ArrayList<>(Arrays.asList(root.val))});

        while (!stack.isEmpty()) {
            Object[] prevPath = stack.pop();
            TreeNode node = (TreeNode) prevPath[0];
            Integer currentSum = (Integer) prevPath[1];
            List<Integer> path = (List<Integer>) prevPath[2];
            if (node.left == null && node.right == null && currentSum == sum) result.add(path);
            if (node.left != null) {
                List<Integer> currentPath = new ArrayList<>(path);
                currentPath.add(node.left.val);
                stack.push(new Object[]{node.left, currentSum + node.left.val, currentPath});
            }
            if (node.right != null) {
                List<Integer> currentPath = new ArrayList<>(path);
                currentPath.add(node.right.val);
                stack.push(new Object[]{node.right, currentSum + node.right.val, currentPath});
            }
        }
        return result;
    }
}
