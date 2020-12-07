package com.interview.leetcode.amazon.easy;

import com.interview.leetcode.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversalBFS {
  public List<List<Integer>> levelOrderBFS(Node root) {
    Queue<Node> q = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> currResult = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        Node curr = q.poll();
        currResult.add(i, curr.val);
        for (Node child : curr.children) {
          q.offer(child);
        }
      }
      result.add(currResult);
    }
    return result;
  }
}
