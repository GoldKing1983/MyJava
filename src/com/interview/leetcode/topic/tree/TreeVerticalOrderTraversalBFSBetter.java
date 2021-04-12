package com.interview.leetcode.topic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

Condition1) index data has higher precedence. So TreeMap sorts by index.
Condition2) if multiple data found in same index, then go by level. If there are multiple values in same level. Then sort by lowest



 */
public class TreeVerticalOrderTraversalBFSBetter {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    Deque<Map.Entry<Integer, TreeNode>> q = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    q.offer(Map.entry(0, root));
    while (!q.isEmpty()) {
      Map.Entry<Integer, TreeNode> currNodeEntry = q.poll();
      int currNodeIndex = currNodeEntry.getKey();
      TreeNode currNode = currNodeEntry.getValue();
      map.computeIfAbsent(currNodeIndex, k -> new ArrayList<>()).add(currNode.val);
      if (currNode.left != null) q.offer(Map.entry(currNodeIndex - 1, currNode.left));

      if (currNode.right != null) q.offer(Map.entry(currNodeIndex + 1, currNode.right));

    }
    return new ArrayList<>(map.values());
  }
}
