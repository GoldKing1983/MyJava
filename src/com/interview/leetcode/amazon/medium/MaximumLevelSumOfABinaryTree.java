package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
Calculate sum at each level and return which level has max sum.
 */
public class MaximumLevelSumOfABinaryTree {
  public int maxLevelSum(TreeNode root) {
    List<Integer> levelSumList = new ArrayList<>();
    recur(root, 0, levelSumList);
    int maxLevel = 1;
    int maxNum = levelSumList.get(0);
    for (int i = 1; i < levelSumList.size(); i++) {
      if (levelSumList.get(i) > maxNum) {
        maxNum = levelSumList.get(i);
        maxLevel = i + 1;
      }
    }
    return maxLevel;
  }

  private void recur(TreeNode root, int level, List<Integer> levelSumList) {
    if (root == null) return;
    if (level == levelSumList.size()) levelSumList.add(root.val);
    else levelSumList.set(level, levelSumList.get(level) + root.val);
    recur(root.left, level + 1, levelSumList);
    recur(root.right, level + 1, levelSumList);
  }
}
