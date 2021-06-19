package com.interview.leetcode.topic.dfs;

/*
https://leetcode.com/problems/number-of-provinces/

1) For each of row, 
 */
public class NumberOfProvincesUnionFind {
  public int findCircleNum(int[][] grid) {
    int provinceCount = grid.length, n = provinceCount;
    int[] root = new int[grid.length];

    for (int i = 0; i < n; i++) root[i] = i;

    for (int sourceNode = 0; sourceNode < n; sourceNode++) {

      int sourceNodeGroup = findRoot(root, sourceNode);

      for (int destinationNode = sourceNode + 1; destinationNode < n; destinationNode++) {
        if (grid[sourceNode][destinationNode] == 0) continue;
        int destinationNodeGroup = findRoot(root, destinationNode);

        if (sourceNodeGroup == destinationNodeGroup) continue;

        root[destinationNodeGroup] = sourceNodeGroup;
        provinceCount--;

      }
    }
    return provinceCount;
  }

  public int findRoot(int[] roots, int id) {
    while (true) {
      if (roots[id] == id) return id;
      //roots[id] = roots[roots[id]]; //performance...
      id = roots[id];
    }
  }
}
