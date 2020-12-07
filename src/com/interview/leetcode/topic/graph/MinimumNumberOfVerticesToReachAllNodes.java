package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] 
represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

Notice that you can return the vertices in any order.

====
1) All nodes are interconnected or no hanging nodes.
2) So find all nodes that has 0 in-degree and return those nodes.

 */
public class MinimumNumberOfVerticesToReachAllNodes {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    boolean[] inDegree = new boolean[n];
    for (List<Integer> edge : edges) {
      //int from = edge.get(0); we don't bother from
      int to = edge.get(1);
      inDegree[to] = true;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!inDegree[i]) result.add(i);
    }
    return result;
  }
}
