package com.interview.leetcode.topic.dfs;

import java.util.*;
//https://leetcode.com/problems/number-of-provinces/
// See FriendCircles
public class NumberOfProvinces {
  public int findCircleNum(int[][] M) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    int n = M.length;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (row == col) continue; // self is always connected, we can ignore
        if (M[row][col] == 0) continue; // not connected
        if (M[row][col] == 1) adjMap.computeIfAbsent(row, k -> new ArrayList<>()).add(col);
      }
    }
    int provinceCount = 0;
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) continue;
      visited.add(i);
      provinceCount++;
      dfs(adjMap, i, visited);
    }
    return provinceCount;
  }

  private void dfs(Map<Integer, List<Integer>> adjMap, int source, Set<Integer> visited) {
    if (adjMap.get(source) == null) return;
    for (int connectedNode : adjMap.get(source)) {
      if (visited.contains(connectedNode)) continue;
      visited.add(connectedNode);
      dfs(adjMap, connectedNode, visited);
    }
  }
}
