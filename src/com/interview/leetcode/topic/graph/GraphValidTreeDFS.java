package com.interview.leetcode.topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution
Requirement: Verify given graph is a valid tree.

Contition1) For the graph to be a valid tree, it must have exactly n - 1 edges.
            if number of edges are less then it is not fully connected or some nodes are hanging.
            if number of edges are more then it is not fully connected or some nodes are hanging or there might be cycle.

Contition2) There should not be any cycle.

Contition3) All nodes should be connected.
========================================================Solution Approach========================================================
1) This problem is simply finding cycle in un-directed-graph.
2) Ex:  
      1 <----> 2

above example is not an cycle. To identify and avoid parent itself as cycle. Pass an argument parentParent.

3) See video https://www.youtube.com/watch?v=bXsUuownnoQ



 */
public class GraphValidTreeDFS {
  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    if (n - 1 != edges.length) return false; // Condition1

    for (int[] edge : edges) {
      adjMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
      adjMap.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
    }

    Set<Integer> visited = new HashSet<>();
    visited.add(0);
    if (!dfs(adjMap, visited, 0, -1)) return false; // Condition2

    return visited.size() == n; // Condition3
  }

  private boolean dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> visited, int parent,
      int parentParent) {
    for (int child : adjMap.getOrDefault(parent, List.of())) {
      if (parentParent == child) continue; // false cycle or visiting parent again  

      if (visited.contains(child)) return false; // cycle detected.

      visited.add(child);
      if (!dfs(adjMap, visited, child, parent)) return false;
    }
    return true;
  }



}
