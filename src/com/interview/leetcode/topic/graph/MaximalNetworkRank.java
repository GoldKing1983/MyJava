package com.interview.leetcode.topic.graph;

import java.util.*;

/*
https://leetcode.com/problems/maximal-network-rank/
===========================================================Requirement===========================================================
1) Given a bidirectionally connected graph.
2) Return the max of connected route of any of 2 nodes.
Ex: for 5 nodes.

    0and1
    0and2
    0and3
    0and4
    1and2
    1and3
    1and4
    2and3
    2and4
    3and4

 */
public class MaximalNetworkRank {
  public int maximalNetworkRank(int n, int[][] roads) {
    Map<Integer, Set<Integer>> g = new HashMap<>();
    for (int[] r : roads) {
      g.computeIfAbsent(r[0], s -> new HashSet<>()).add(r[1]);
      g.computeIfAbsent(r[1], s -> new HashSet<>()).add(r[0]);
    }
    int maxConnectedRoute = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        Set<Integer> set1 = g.getOrDefault(i, Collections.emptySet()),
            set2 = g.getOrDefault(j, Collections.emptySet());
        int set1ContainingSet2 = set1.contains(j) ? 1 : 0;
        // int set2ContainingSet1 = set2.contains(i) ? 1 : 0;

        maxConnectedRoute = Math.max(maxConnectedRoute, set1.size() + set2.size() - set1ContainingSet2);
        // maxConnectedRoute = Math.max(maxConnectedRoute, set1.size() + set2.size() -set2ContainingSet1);
      }
    }
    return maxConnectedRoute;
  }
}
