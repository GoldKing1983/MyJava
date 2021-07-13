package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/minimum-height-trees/
=================================================Solution Approach - Not Optimal=================================================
1) For each of node, find height.
2) If currentNodeHeight is less than minHeight. clear result. Add currentNode to result.
3) If currentNodeHeight is equal to minHeight. Add currentNode to result.
4) If currentNodeHeight is larger than minHeight. No operation.
 
 */
public class MinimumHeightTreesBruteForce {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
      adjMap.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
    }
    List<Integer> result = new ArrayList<>();
    int minHeight = n;
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      visited.add(i);
      int currentNodeHeight = height(adjMap, i, visited);
      visited.clear();
      //System.out.println(currentNodeHeight);
      if (currentNodeHeight < minHeight) {
        result.clear();
        minHeight = currentNodeHeight;
        result.add(i);
      } else if (currentNodeHeight == minHeight) {
        result.add(i);
      } else {
        // currentNodeHeight is bigger. Nothing to do
      }
    }
    return result;

  }

  private int height(Map<Integer, List<Integer>> adjMap, int parent, Set<Integer> visited) {
    if (adjMap.get(parent) == null) return -1; // leaf reached
    int height = 0;
    for (int child : adjMap.get(parent)) {
      if (visited.contains(child)) continue;
      visited.add(child);
      int currentHeight = height(adjMap, child, visited) + 1;
      height = Math.max(height, currentHeight);
    }
    return height;
  }
}
