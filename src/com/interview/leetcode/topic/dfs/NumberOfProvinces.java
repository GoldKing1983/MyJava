package com.interview.leetcode.topic.dfs;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/number-of-provinces/

See Also FriendCircles.

 */
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    Set<Integer> visited = new HashSet<>();
    int provinceCount = 0;
    for (int i = 0; i < n; i++) {
      if (visited.contains(i)) continue;
      visited.add(i);
      provinceCount++;
      dfs(isConnected, n, i, visited);
    }
    return provinceCount;
  }

  private void dfs(int[][] isConnected, int n, int parent, Set<Integer> visited) {
    for (int i = 0, neighbors[] = isConnected[parent]; i < n; i++) {
      if (visited.contains(i) || neighbors[i] == 0) continue;
      visited.add(i);
      dfs(isConnected, n, i, visited);
    }
  }
}
