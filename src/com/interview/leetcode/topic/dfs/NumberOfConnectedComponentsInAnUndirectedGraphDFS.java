package com.interview.leetcode.topic.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
===========================================================Requirement===========================================================
Input: n = 4, edges = [[1,2],[2,3]] , Output: 2...
          1<->2<->3
          0

node1 is connected all the way and forming only 1 connection.
But node0 is hanging which is not connected to any edge. So output is 2.

This problem is logically same as NumberOfIslandsDFS
*
*/
public class NumberOfConnectedComponentsInAnUndirectedGraphDFS {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
      adjMap.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
    }
    Set<Integer> visited = new HashSet<>();
    int connectedComponentCount = 0;
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) continue;
      connectedComponentCount++;
      visited.add(i);
      dfs(adjMap, visited, i);
    }
    return connectedComponentCount;
  }

  private void dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> visited, int parent) {
    for (int child : adjMap.getOrDefault(parent, List.of())) {
      if (visited.contains(child)) continue;
      visited.add(child);
      dfs(adjMap, visited, child);
    }
  }
}
