package com.interview.leetcode.topic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

1) Aim of this code is to avoid sorting by TreeMap.
2) I can avoid sorting if I get the minRange and maxRange.. 
Then save the value to appropriate index directly from leftToRight at each level.
        1
       / \
      2   3
      Here in above minRange is -1.
      
      If I set rootIndex with -(-1) = 1. Then rootIndex starts with 1. leftIndex is 0.    

Note: We traverse the entire tree 2 time. firstTime to get the minRange/maxRange. secondTime to set the result.
 */
public class TreeVerticalOrderTraversalBFSBest {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    Deque<Map.Entry<Integer, TreeNode>> q = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    getMinMaxRange(root, 0);
    int tempMinRange = minRange;
    while (minRange++ <= maxRange) result.add(new ArrayList<>());

    q.offer(Map.entry(-tempMinRange, root));
    while (!q.isEmpty()) {
      Map.Entry<Integer, TreeNode> currNodeEntry = q.poll();
      int currNodeIndex = currNodeEntry.getKey();
      TreeNode currNode = currNodeEntry.getValue();
      result.get(currNodeIndex).add(currNode.val);

      if (currNode.left != null) q.offer(Map.entry(currNodeIndex - 1, currNode.left));

      if (currNode.right != null) q.offer(Map.entry(currNodeIndex + 1, currNode.right));

    }
    return result;
  }

  int minRange = Integer.MAX_VALUE;
  int maxRange = Integer.MIN_VALUE;

  private void getMinMaxRange(TreeNode root, int index) {
    if (root == null) return;
    minRange = Math.min(minRange, index);
    maxRange = Math.max(maxRange, index);
    getMinMaxRange(root.left, index - 1);
    getMinMaxRange(root.right, index + 1);
  }
}
