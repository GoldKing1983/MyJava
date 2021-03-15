package com.interview.leetcode.topic.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
===========================================================Requirement===========================================================
Input: n = 4, edges = [[1,2],[2,3]] , Output: 2...
          1<->2<->3
          0

node1 is connected all the way and forming only 1 connection.
But node0 is hanging which is not connected to any edge. So output is 2.
*
*/
public class NumberOfConnectedComponentsInAnUndirectedGraph_DFS {
  public int countComponents(int n, int[][] edges) {
    /*
    1) build adjMap bidirectionally
    2) do dfs and mark visited..
    3) no of times dfs runs is the answer.
    */
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
      adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    Set<Integer> visited = new HashSet<>();
    int connectedComponentCount = 0;
    while (n-- > 0) {
      if (visited.contains(n)) continue;
      connectedComponentCount++;
      dfs(n, adjMap, visited);
    }
    return connectedComponentCount;
  }

  private void dfs(int source, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
    visited.add(source);
    if (adjMap.get(source) == null) return;
    for (Integer neighbor : adjMap.get(source)) {
      if (visited.contains(neighbor)) continue;
      dfs(neighbor, adjMap, visited);
    }
  }
}
