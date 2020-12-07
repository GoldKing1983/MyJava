package com.interview.leetcode.amazon.easy;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.Node;

/*
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 * 1) Similar to binary tree height. But instead of "left" and "right" using for loop.
 *
 */
public class MaximumDepthOfNAryTreeBFS {

  public int maxDepth1(Node root) {
    Queue<Node> q = new LinkedList<>();
    if (root != null) q.offer(root);
    int depth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      depth++;
      for (int i = 0; i < size; i++) {
        Node node = q.poll();
        for (Node n : node.children) {
          q.offer(n);
        }
      }
    }
    return depth;
  }
}
