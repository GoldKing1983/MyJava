package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/average-of-levels-in-binary-tree/
						1           => 1/1  = 1
					 /	   \
					2	    3       => 5/2  = 2.5
				   / \     / \
				  4   5   6   7     => 22/4 = 5.5

*
*/
public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Integer> count = new ArrayList<>();
    List<Double> res = new ArrayList<>();
    average(root, 0, res, count);
    for (int i = 0; i < res.size(); i++) res.set(i, res.get(i) / count.get(i));
    return res;
  }

  public void average(TreeNode t, int level, List<Double> sum, List<Integer> count) {
    if (t == null) return;
    if (level == sum.size()) {
      sum.add(1.0 * t.val);
      count.add(1);
    } else {
      sum.set(level, sum.get(level) + t.val);
      count.set(level, count.get(level) + 1);
    }
    average(t.left, level + 1, sum, count);
    average(t.right, level + 1, sum, count);
  }

  public List<Double> averageOfLevelsBFS(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      Double sumOfLevel = 0.0d;
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.poll();
        sumOfLevel += temp.val;
        if (temp.left != null) q.offer(temp.left);
        if (temp.right != null) q.offer(temp.right);
      }
      result.add(sumOfLevel / size);
    }
    return result;
  }
}
